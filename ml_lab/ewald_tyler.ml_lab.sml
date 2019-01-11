(***************************************************************
*
* CSCI 305 - ML Programming Lab
*
* <Tyler> <Ewald>
* <t.ewald95@gmail.com>
*
***************************************************************)
(* Changes default print depth to an arbitrary depth size of 60,
   controlling the amount of information that is printed *)
Control.Print.printDepth := 60;

(* Define your data type and functions here *)
fun f [] = [] (* a *)
  | f (x::xs) = (x + 1) :: (f xs) (* b *)

(* constructs datatypes for the function *)
datatype 'element set = Empty
  | Set of 'element * 'element set;

(* isMember function returns if e is of a set *)
fun isMember e Empty = false
  | isMember e (Set (x,xs)) =
    e = x orelse isMember e xs;

fun isSet Empty = true
  | isSet (Set (x,xs)) =
    if (isMember x xs)
    then false
    else isSet xs;

(* converts a list to a set, getting rid of any duplicate variables and calling
   the first only *)
fun list2Set ([]) = Empty
  | list2Set (x::xs) =
    let fun x2 [] = Empty (* x2 signifies the duplicate variable *)
      | x2 (x::xs) = Set(x, x2 (xs))
        in
          if isMember x (x2(xs))
          then list2Set(xs)
          else Set(x, list2Set(xs))
      end

(* takes the set intersection of set `set1` and set `set2` and returns a set
   representing the mathematical intersection of the two sets *)
fun union set1 (Empty) = set1
  | union (Empty) set1 = set1
  | union (Set(set1,set2)) set =
    if(isMember set1 set)
    then union set2 set
    else Set(set1, union set2 set);

(* takes the set union of set `set1` and set `set2` and returns a
   set representing the mathematical union of the two sets *)
fun intersect set1 (Empty) = Empty
  | intersect (Empty) set1 = Empty
  | intersect (Set(set1, set2)) set =
  	if(isMember set1 set)
    then Set(set1, intersect set2 set)
    else intersect set2 set;

(* Simple function to stringify the contents of a Set of characters *)
fun stringifyCharSet Empty = ""
  | stringifyCharSet (Set(y, ys)) = Char.toString(y) ^ " " ^ stringifyCharSet(ys);

(* Simple function to stringify the contents of a Set of ints *)
fun stringifyIntSet Empty = ""
  | stringifyIntSet (Set(w, ws)) = Int.toString(w) ^ " " ^ stringifyIntSet(ws);

(* Simple function to stringify the contents of a Set of strings *)
fun stringifyStringSet Empty = ""
  | stringifyStringSet (Set(z, zs)) = z ^ " " ^ stringifyStringSet(zs);

(* Simple function that prints a set of integers *)
fun print_int x = print ("{ " ^ stringifyIntSet(x) ^ "}\n");

(* Simple function that prints a set of strings *)
fun print_str x = print ("{ " ^ stringifyStringSet(x) ^ "}\n");

(* Simple function that prints a set of characters *)
fun print_chr x = print ("{ " ^ stringifyCharSet(x) ^ "}\n");

list2Set [1, 3, 2];
list2Set [#"a", #"b", #"c"];
list2Set [];
list2Set [6, 2, 2];
list2Set ["x", "y", "z", "x"];

(* Question 1 *)
f [3, 1, 4, 1, 5, 9];

(* Question 5 *)
val quest5 = isMember "one" (list2Set ["1", "2", "3", "4"]);
print ("\nQuestion 5: " ^ Bool.toString(quest5) ^ "\n");

(* Question 7 *)
val quest7 = list2Set ["it", "was", "the", "best", "of", "times,", "it", "was", "the", "worst", "of", "times"];
print "\nQuestion 7: ";
print_str quest7;
print "\n";

(* Question 9 *)
print "\nQuestion 9: ";
print_str (union (list2Set ["green", "eggs", "and"]) (list2Set ["ham"]));

(* Question 10 *)
print "\nQuestion 10: ";
print_str (intersect (list2Set ["stewed", "tomatoes", "and", "macaroni"]) (list2Set ["macaroni", "and", "cheese"]));

OS.Process.exit(OS.Process.success);
