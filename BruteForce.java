/* Author: Kristin Piorkowski
 * Class: BruteForce
 * Purpose: This class implements the brute force algorithm
 * to search for a pattern in a string.
 */

public class BruteForce {

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
