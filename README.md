# README
## Pattern Searching Algorithms
### Implemented by: Caleb M., Aria K., Sasha J., Kristin P.

## Pattern Searching Algorithms Overview
Pattern Searching algorithms are algorithms that are handy for searching a string within another given string.
There are numerous pattern matching algorithms, for our specific implementation we decided to use the
Naive Approach (Brute Force Method), Boyer-Moore Method, KMP Method, and the Rabin-Karp Method. The
complexity of each algorithm varies from algorithm to algorithm. Some features of pattern searching
algorithms are: Recognize familiar patterns quickly and accurately, recognize and classify unfamiliar 
patterns, identify patterns even when partly hidden, or recognize patterns quickly with ease, and with
automaticity. 

## Naive Algorithm for Pattern Searching (Brute Force Method)
The Naive Algorithm was implemented by Kristin P. The brute force method slides the pattern over the text 
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

RUNTIME: O(nm)
Space Used: O(1).

Implementation of code and tests:

  The BruteForce class implements a search method that take
the string as an input and the string pattern as the other input. If the
pattern is found in the string, the method will return "Pattern found",
if the pattern is not found in the string, the method will return "Pattern not found".
Else, if the string is shorter than the pattern searching for, the method
will return "String length smaller than pattern".

  The way this code and method is tested is through JUnit testing.
The first 10 test methods are testing for pattern found.
The second set of 10 test methods are testing for the pattern not found.
The third set of 10 test methods are testing for if the string is shorter
than the pattern. This way there is a thorough check for all the cases possible
with different tests.

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

RUNTIME: O(nm).

Space Used: O(1).

## KMP Algorithm for Pattern Searching
The KMP Algorithm was implemeented by Aria K. The KMP Algorithm searches for a pattern in a test using a table of prefixes.
This algorithm uses the degenerating property, which makes it better for patterns with reappearing sub-patterns
It also uses previous matches to start searching the next set of characters in the text after a mismatch in 
order to save time. The Most important part of the KMP algorithm is the LPS (longest proper prefix that is also a suffix)
table, sometimes called the Prefix table. The table is a list the length of the pattern that indicates the indices where 
repeat characters occur in the pattern. The table is used when traversing the text in order to skip places where we know
that characters will match. Time complexity is O(n + m) where n is the length of the text and m is the length of the pattern
due to the traversal of the text and simultaneous traversal of the LPS table. Space usage is O(m) because an array the size 
of the pattern is created for the LPS table.

EX:
text = "I do not like them in a house.
I do not like them with a mouse.
I do not like them here or there.
I do not like them anywhere.
I do not like green eggs and ham.
I do not like them, Sam-I-Am." - Dr. Seuss' "Green Eggs and Ham"
pattern = "like"

output: 

Pattern found at index 9.

Pattern found at index 41.

Pattern found at index 75.

Pattern found at index 110.

Pattern found at index 140.

Pattern found at index 175.

All done!

RUNTIME: O(n+m).

Space Used: O(1).

## Rabin-Karp Algorithm for Pattern Searching
The Rabin-Karp Algorithm was implemented by Caleb M. The Rabin-Karp algorithm is given a text sequence as a String 
(character array) and a pattern sequence as a String (character array). The text sequence is of size n and the pattern
sequence is of size m. You may assume that n > m. The Rabin-Karp method is similar to the Naive algorithm (see Brute Force Method), 
but the Rabin-Karp method uses a hash function to compare the total hash code of the pattern sequence to the total hash code 
of the current substring of the text sequence. Each substring will be of size m. 

  Handling the hash value is as following, first find the hash value by using a rolling hash function. The reason
the Rabin-Karp method uses a rolling hash function is because it effectively finds the next hash value of the the next
substring by removing the beginning character of the first substring and adding the next character of the last index
of the previous substring to form a new hash value for the next substring. This works better and more efficiently then
determining a new hash value for the next substring by starting from scratch. We find the hash value by choosing a base
and a modulus, we determine the modulus as a good prime number to ensure good distribution of the hash values. We
determine the base, which is often the size of the total character set, (which is 256 for ASCII characters). 
Nextly, initalize the hash value and calculate the entire hash value of the pattern by adding the hash value of the character
at the current position to hash. 

  Once the hash value is determined, determine the hash value of the pattern and the text sequence, if the hash values of
the pattern sequence and the text sequence are the same then do a character by character search to determine if the characters
are the same. The reason we continue to do a character by character search is because we want to avoid hash collisions. If the 
pattern sequence and the current substring of the text sequence has the same hash code and have different characters or a different
sequence then the patterns are not the same. Once the substring and the pattern are fully compared then we will use the rolling
hash function to determine the next hash value of the next substring. We'll move the window by removing the first character of
the string and add the next index which is the next character to the substring to form a new subtring to compare. 

  The Rabin-Karp method has an average and best-case runtime of O(n+m), where n is the size of the character array, and m is the
size of the pattern array. It has a worst case runtime of O(nm), where n is the size of the character array, and m is the
size of the pattern array. The worst case occurs when all the characters of the pattern and text sequence are the same hash values
for all the substrings of the text sequence, but none of the patterns match. A case would be every substring of the same size as the
pattern sequence have the same hash value but are sorted in a different order (i.e., 'abc' != 'cba' and also called a spurious hit). 
To avoid this worst case, the better developed rolling a hash function develops a better runtime for the code.The Rabin-Karp method
uses O(1) auxiliary space, all the work is done on the text sequence.

EX:
The pattern sequence of this test is: AB. And the text sequence is: AABAABABABBAABAABBBAABAABABBA.

Pattern Found at index 1.

Pattern Found at index 4.

Pattern Found at index 6.

Pattern Found at index 8.

Pattern Found at index 12.

Pattern Found at index 15.

Pattern Found at index 20.

Pattern Found at index 23.

Pattern Found at index 25.

Total number of patterns found were 9.

RUNTIME: O(n+m).

Space Used: O(1).
