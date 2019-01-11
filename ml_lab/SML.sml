(***************************************************************
*
* CSCI 305 - ML Programming Lab
*
* <Chance> <Coleman>
* <chancec63@gmail.com>
*
***************************************************************)

(* Define your data type and functions here *)

fun f [] = [] (* a *)
   | f (x::xs) = (x + 1) :: (f xs); (* b *)

f [3, 1, 4, 1, 5, 9]
