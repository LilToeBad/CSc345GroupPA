# README
## Pattern Searching Algorithms
### Implemented by: Caleb M., Aria K., Sasha J., Kristin L.

## Pattern Searching Algorithms Overview
Pattern Searching algorithms are algorithms that are handy for searching a string within another given string.
There are numerous pattern matching algorithms, for our specific implementation we decided to use the
Naive Approach (Brute Force Method), Boyer-Moore Method, KMP Method, and the Rabin-Karp Method. The
complexity of each algorithm varies from algorithm to algorithm. Some features of pattern searching
algorithms are: Recognize familiar patterns quickly and accurately, recognize and classify unfamiliar 
patterns, identify patterns even when partly hidden, or recognize patterns quickly with ease, and with
automaticity. 

## Naive Algorithm for Pattern Searching (Brute Force Method)
The Naive Algorithm was implemented by Kristin L. The brute force method slides the pattern over the text 
sequence one by one (character by character), if a match is found, then slide by 1 again to chck for the
subsequent matches. The brute force algorthim solves a problem through exhuastion. Iterating throughe every
possibility to solve the problem. Time complexity is porportional to the input size, for the size of the 
pattern is m, and the size of the text is n, where we can assume that n > m. The implementation of the
brute force method is simple and consistent but very slow. The best case runtime of this method is O(n)
which only happens if the pattern is found at the very beginning of the text. The worst case is O(n^2)
where the pattern doesn't appear in the text at all. This algorithm will perform a total of O((n-m+1)*m)
operations. This code is implemented as the ... 

EX:
"If there is a lock of 4-digit PIN. 
The digits to be chosen from 0-9 then the brute force
will be trying all possible combinations one by one like
0001, 0002, 0003, 0004, and so on until we get the right PIN.
In the worst case, it will take 10,000 tries to find the right combination." - GeeksforGeeks

RUNTIME: O(mn) <- Average Case.
Space Used: O(1) 

## Boyer-Moore Algorithm for Pattern Searching
The Boyer-Moore Algorithm was implemented by Sasha J. The algorithm is a combination, but can be independent, 
of Bad Character Heuristic and Good Suffix Heuristic approaches. Using these two methods, the algorithm skips 
as many characters as it can. In the Bad Character Heuristic, if the current character doesn't match the current 
character of the pattern, then the characters of the pattern will be shifted until there is a match or until the
pattern moves past the mismatched character. The average runtime complexity of the algorithm is O(nm) and its 
auxilary space is O(1). The Bad Character Heuristic may take O(n^2) time in the worst case scenario which occurs 
when all characters of the text and pattern are the same. 
EX: 
text = "SSSSSSSSSS" pattern = "SSS"

However, the BCH method may take O(m/n) time in the best case and this happens when all characters of the text 
and pattern are different. On the other hand, just like the Bad Character Heuristic, the Good Suffix Heuristic
method generates a table for good suffixes. This helps determine how much to shift a pattern when a mismatch occurs 
and when a partial match has been found. The runtime of this method is O(n) because it iterates thrugh every 
character of the text at least once.  

RUNTIME: O(nm) <- Average Case.
Space Used: O(1)
