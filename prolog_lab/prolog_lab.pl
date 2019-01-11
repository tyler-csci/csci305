/*
*Tyler Ewald
*CSCI 305 Prolog Lab 2
*/

/*mother/2*/
mother(M, C):- parent(M, C), female(M).

/*father/2*/
father(F, C):- parent(F, C), male(F).

/*spouse/2
basically need union for marriage going both ways*/
spouse(X, Y):- married(X, Y); married(Y, X).

/*child/2 opposite of what parent relationship would be*/
child(C, P):- parent(P, C).

/*son/2 child rule plus male gender*/
son(S, P):- parent(P, S), male(S).

/*daughter/2 child rule plus female gender*/
daughter(D, P):- parent(P, D), female(D).

/*sibling/2 child X and child Y are siblings if they do not have the same parents*/
sibling(X, Y):- parent(P, Y), parent(P, X), not(X = Y).

/*brother/2 sibling rule plus male gender*/
brother(B, Y):- sibling(B, Y), male(B).

/*sister/2 sibling rule plus female gender*/
sister(S, Y):- sibling(S, Y), female(S).

/*uncle/2 one for blood, one for marriage. Must be siblings of the parent plus
need male gender. Second function has spouse added for marriage*/
uncle(U, Y):- parent(P, Y), sibling(U, P), male(U).
uncle(U, Y):- parent(P, Y), sibling(P, M), spouse(U, M), male(U).

/*aunt/2 one for blood, one for marriage. Must be siblings of the parent plus
need female gender. Second function has spouse added for marriage*/
aunt(A, Y):- parent(P, Y), sibling(A, P), female(A).
aunt(A, Y):- parent(P, Y), sibling(P, M), spouse(A, M), female(A).

/*grandparent/2 parent rule plus parent of parent*/
grandparent(G, Y):- parent(P, Y), parent(G, P).

/*grandfather/2 parent rule plus male gender*/
grandfather(Gf, Y):- grandparent(Gf, Y), male(Gf).

/*grandmother/2 parent rule plus female gender*/
grandmother(Gm, Y):- grandparent(Gm, Y), female(Gm).

/*grandchild/2 opposite of grandparent rule*/
grandchild(Gc, G):- grandparent(G, Gc).

/*ancester/2 ancestor must be parent or parent of parent. Uses recursion to find
all ancestors*/
ancestor(A, Y):- parent(A, Y); parent(P, Y), ancestor(A, P).

/*descendant/2 opposite of descendant rule*/
descendant(D, Y):- ancestor(Y, D).

/*older/2 compares when X was born to when Y was born and checks to make sure
Y was born before X*/
older(X, Y):- born(X, Bx), born(Y, By), Bx < By.

/*younger/2 opposite of older rule*/
younger(X, Y):- older(Y, X).

/*regentWhenBorn/2 gets when Y was born and checks the start and end date of
when the regent reigned*/
regentWhenBorn(RWB, Y):- born(Y, Z), reigned(RWB, B, C), B < Z, C > Z.

/*cousin/2 extra credit rule*/
cousin(X, Y) :- parent(P1, X), parent(P2, Y), sibling(P1, P2).
