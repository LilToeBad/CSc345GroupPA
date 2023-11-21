import java.util.Scanner;

public class PatternSearch {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = userInput.nextLine();
		System.out.println("Your name: " + name);
		
		boolean resume = true;
		while(resume){
			System.out.println("Which test case would you like to perform? ");
			System.out.println("Pick one of the following:\n1: Brute Force\n"
					+ "2: Boyer-Moore\n3: KMP\n4: Rabin-Karp");
			
			int number = userInput.nextInt();
			
			if (number == 1) {
				BruteForceTest.main();
				System.out.println("All 30 test cases passed!");
			}
			else if (number == 2){
				testCasesBoyer.main();
			}
			
			else if (number == 3){
				KMPTest.main();
			}
			
			else if (number == 4){
				RabinKarpTest.main();
			}
			else {
				System.out.println("You didn't test anything.");
			}
			
			System.out.println("Would you like to continue? ");
			System.out.println("[Y/N]");
			if(userInput.next().equals("N")){
				resume = false;
			}
		}
		
	}

	

/* Author: Kristin Piorkowski
 * Class: BruteForce
 * Purpose: This class implements the brute force algorithm
 * to search for a pattern in a string.
 */

class BruteForce {

	// This method is the brute force search method
	public static String search(String input, String pattern) {
		// length of the input string
		int inputLen = input.length();
		// length of the pattern string
		int patternLen = pattern.length();
		// length between the input string and the pattern string
		// this is to make sure the search for the pattern does not
		// continue to search out of bounds
		int bounds = inputLen - patternLen;

		// searches each letter in string for pattern
		for (int i = 0; i <= bounds; i++) {
			int j;
			// searches first letter of pattern once matched in string
			for (j = 0; j < patternLen; j++) {
				// compare character in string to pattern character in corresponding position
				// if not equal break
				if (!input.substring(i + j, i + j + 1).equals(pattern.substring(j, j + 1))) {
					break;
				}
			}
			// pattern found if out of break statement and
			// verified that j is same length as pattern
			if (j == patternLen) {
				return "Pattern found";
			}
		}
		// if input string length is smaller than pattern length
		if (inputLen < patternLen) {
			return "String length smaller than pattern";
		} else {
			// pattern not found in string
			return "Pattern not found";
		}
	}
}
	
	
	

	
// Sasha Joe
// CSC 345, Fall '23
// boyerMethod.java for team project


class boyerMethod {
	
	static int[] badCharacters = new int[256];

	public static void search(char[] string, char[] pattern){
		checkBadCharHeuristics(pattern);
		
		int numOfShifts = 0;
		
		while((string.length - pattern.length) >= numOfShifts) { // potential alignment
			
			int matchingIndexNum = pattern.length-1;
			
			while(matchingIndexNum >= 0 && pattern[matchingIndexNum] == string[numOfShifts+matchingIndexNum]) {
				matchingIndexNum--;
			}
				
			if(matchingIndexNum < 0) { // pattern is present at current shift
				System.out.println("Pattern occurs at index: " + numOfShifts);
					
					if(numOfShifts+pattern.length < string.length) {	// checks if the pattern occurs at the end of the text
						int index = string[numOfShifts+pattern.length];
						numOfShifts += pattern.length - badCharacters[index];
					}else {
						numOfShifts++;
					}
				}
			else {
					// shifts the pattern so that the bad character in the text so it'll align with the pattern
					int index = string[numOfShifts+matchingIndexNum];
					numOfShifts += ( 1 > (matchingIndexNum - badCharacters[index]))? 1: (matchingIndexNum - badCharacters[index]);
				}
			}
		}
		  
	public static void checkBadCharHeuristics(char[] pattern){
	  /*
   * The idea of bad character heuristic is simple. The character of the 
   * text which doesn’t match with the current character of the pattern
   * is called the Bad Character. Upon mismatch, we shift the pattern until– 

		- The mismatch becomes a match.
		- Pattern P moves past the mismatched character.
   */
		
		 for(int i = 0; i < 256; i++) {
			 badCharacters[i] = -1;	// initializing every characters occurrences
		 }
		 
		 for(int i = 0; i < pattern.length; i++) {
			 //System.out.println("here");
			 int ascii = pattern[i];
			 badCharacters[ascii] = i;
			 //System.out.println(pattern[i] + " " + ascii);

		 }
	}
}


/* Author: Aria Kelley
*  File: KMP.java
*  Purpose: This file implements a KMP pattern searching algorithm
*/
class KMP{
	
	public static void KMPSearch(String pattern, String text) {
		int m = pattern.length();
		int n = text.length();
		
		// create lps[] (longest prefix suffix array)
		int lps[] = new int[m];
		int j = 0;
		
		// calculate lps array
		LPSarray(pattern, m, lps);
		
		int i = 0;
		while ((n - i) >= (m - j)) {
			
			// found match
			if (pattern.charAt(j) == text.charAt(i)) {
				j++;
				i++;
			}
			
			// pattern fully found (reached the end of the pattern)
			if (j == m) {
				System.out.println("Pattern found at index " + (i - j) + ".");
				j = lps[j - 1];
			}
			
			// mismatch after j matches
			else if (i < n) {
				if (pattern.charAt(j) != text.charAt(i)) {
					if (j == 0) {
						i = i + 1;
					}
					else {
						j = lps[j - 1];
					}
				}
			}
		}
	}
	
	public static void LPSarray(String pattern, int m, int lps[]) {
		// length of previous longest prefix suffix
		int i = 1;
		int j = 0;
		lps[0] = 0;
		
		// while i < length of pattern
		while (i < m) {
			// found repeat in pattern
			if (pattern.charAt(i) == pattern.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			}
			
			//no repeat
			else {
				if (j == 0) {
					lps[i] = j;
					i++;
				}
				
				else {
					j = lps[j - 1];
				}
			}
		}
	}
}

/* Author: Caleb McKinley
 * Class: RabinKarpMethod
 * Purpose: This class implements the Rabin Karp algorithm
 * for the pattern searching method. 
 */
class RabinKarpMethod{
		
		
		// BASE is the number of characters in the ASCII table.
		public final static int BASE = 256;
		
		/* The search method performs a pattern matching search on the text string.
		 * In the method, the hash value for the entire sequence is calculated
		 * and the hash code for the pattern sequence and text sequence is calculated.
		 * If the hash codes for the pattern and text match, do a character by character
		 * search to see if you have a complete match.  This work is done in place
		 * and it does a linear search, the runtime is O(n+m) done in O(1) space.
		 */
		public static void search(String pattern, String text, int prime){
			
			int totalFinds = 0;														// Counts the total number of sequences found in the pattern.
			
			System.out.println("The pattern sequence of this test is: " + pattern 
					+ ". And the text sequence is: " + text + ".");
			
			if (pattern == null || text == null) {return;}							// If any input is empty, just return
			
			int pLen = pattern.length();											// Save the value of the pattern length into pLen
			int tLen = text.length();												// Save the value of the text length in tLen
			
			if (pLen > tLen) {return;}												// If the size of the pattern is bigger than the text size then return
			
			long pHash = 0;															// Initialize pattern hash value
			long tHash = 0;															// Initialize text hash value
			long hash = 1;															// Initialize the hash value for the rolling hash
			int i,j;
			
			hash = rollingHash(hash, pLen, prime);									// Update hash value
			
			for (int index = 0; index < pLen; index++){
				pHash = (BASE * pHash + pattern.charAt(index)) % prime;				// Calculate the hash value of the pattern sequence
				tHash = (BASE * tHash + text.charAt(index)) % prime;				// Calculate the hash value of the text sequence 
			}
			
			for (i = 0; i < tLen - pLen; i++){										// Iterate over the text sequence
				
				/* The condition pHash == tHash checks if the hash codes are the same.
				 * If they are the same they go through each character one by one
				 * to see if you have an exact match.
				 */
				
				if (pHash == tHash){								
					
					for (j = 0; j < pLen; j++){										// Start iteration of the condition was true
						if (text.charAt(i+j) != pattern.charAt(j)) 					// If the characters don't match, break the character search
							break;
					}
					
					/* The condition j == pLen only runs if the hash codes of the
					 * pattern and the text sequence are the same AND every 
					 * character in the search matched. We know this because
					 * the index, j, will be the same value of the size of the 
					 * pattern. I.e pattern[0, pLen-1] == text[i, i+pLen-1]
					 */
					if (j == pLen){																						
						System.out.println("Pattern Found at index " + i);			// Print the starting index where the match was found
						totalFinds++;
					}
				}
				
				/* The condition i < tLen - pLen runs when you need
				 * to calculate the hash value for the next window of the
				 * text sequence. It'll remove the leading character
				 * and add the trailing character, updating the hash 
				 * code. 
				 */
				if (i < tLen - pLen - 1){
					tHash = (BASE * (tHash - text.charAt(i) * hash) + text.charAt(i + pLen)) % prime;
					
					// Handles the case IF the hash code goes negative, if so convert it back to positive. 
					if (tHash < 0)
						tHash += prime;
				}
			}
			System.out.print("\nTotal number of patterns found were " + totalFinds + ".\n");
		}
		
		
		/* The rollingHash method updates the hash value of the newly 
		 * found hash value of the next substring from performing
		 * the rolling hash.
		 */
		public static long rollingHash(long hash, int pLen, int prime){
			for (int index = 0; index < pLen-1; index++){
				hash = (hash * BASE) % prime;
			}
			// The value would return pow(BASE, pattern.length()-1) % Prime Value
			return hash;			
			
		}
	}
}
