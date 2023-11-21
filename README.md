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
operations. 

EX:
"If there is a lock of 4-digit PIN. 
The digits to be chosen from 0-9 then the brute force
will be trying all possible combinations one by one like
0001, 0002, 0003, 0004, and so on until we get the right PIN.
In the worst case, it will take 10,000 tries to find the right combination." - GeeksforGeeks

RUNTIME: O(mn) <- Average Case.
Searching for string of "n" characters in string of "m" characters, 
it would take n* m amount of tries. 
