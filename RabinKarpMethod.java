/* Author: Caleb McKinley
 * Class: RabinKarpMethod
 * Purpose: This class implements the Rabin Karp algorithm
 * for the pattern searching method. 
 */

public class RabinKarpMethod {
	
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
		
		int totalFinds = 0;									// Counts the total number of sequences found in the pattern.
		
		System.out.println("The pattern sequence of this test is: " + pattern 
				+ ". And the text sequence is: " + text + ".");
		
		if (pattern == null || text == null) {return;}						// If any input is empty, just return
		
		int pLen = pattern.length();								// Save the value of the pattern length into pLen
		int tLen = text.length();								// Save the value of the text length in tLen
		
		if (pLen > tLen) {return;}								// If the size of the pattern is bigger than the text size then return
		
		long pHash = 0;										// Initialize pattern hash value
		long tHash = 0;										// Initialize text hash value
		long hash = 1;										// Initialize the hash value for the rolling hash
		int i,j;
		
		hash = rollingHash(hash, pLen, prime);							// Update hash value
		
		for (int index = 0; index < pLen; index++){
			pHash = (BASE * pHash + pattern.charAt(index)) % prime;				// Calculate the hash value of the pattern sequence
			tHash = (BASE * tHash + text.charAt(index)) % prime;				// Calculate the hash value of the text sequence 
		}
		
		for (i = 0; i < tLen - pLen; i++){							// Iterate over the text sequence
			
			/* The condition pHash == tHash checks if the hash codes are the same.
			 * If they are the same they go through each character one by one
			 * to see if you have an exact match.
			 */
			
			if (pHash == tHash){								
				
				for (j = 0; j < pLen; j++){						// Start iteration of the condition was true
					if (text.charAt(i+j) != pattern.charAt(j)) 			// If the characters don't match, break the character search
						break;
				}
				
				/* The condition j == pLen only runs if the hash codes of the
				 * pattern and the text sequence are the same AND every 
				 * character in the search matched. We know this because
				 * the index, j, will be the same value of the size of the 
				 * pattern. I.e pattern[0, pLen-1] == text[i, i+pLen-1]
				 */
				if (j == pLen){																						
					System.out.println("Pattern Found at index " + i);		// Print the starting index where the match was found
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
