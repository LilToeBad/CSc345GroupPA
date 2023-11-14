/* Author: Aria Kelley
*  File: KMP.java
*  Purpose: This file implementa a KMP pattern searching algorithm
*/
public class KMP {

  public static void main(String[] args) {
		String text = "";
		String pattern = "";
		new KMP().KMPSearch(pattern, text);

	}
	
	public void KMPSearch(String pattern, String text) {
		int M = pattern.length();
		int N = text.length();
		
		// create lps[] (longest prefix suffix array)
		int lps[] = new int[M];
		int j = 0;
		
		// calculate lps array
		LPSarray(pattern, M, lps);
		
		int i = 0;
		while ((N - i) >= (M - j)) {
			
			// found match
			if (pattern.charAt(j) == text.charAt(i)) {
				j++;
				i++;
			}
			
			// pattern fully found
			if (j == M) {
				System.out.println("Pattern found at index" + (i - j) + "!!");
				j = lps[j - 1];
			}
			
			// mismatch after j matches
			else if (i < N && pattern.charAt(j) != text.charAt(i)) {
				if (j != 0) {
					j = lps[j - 1];
				}
				else {
					i = i + 1;
				}
			}
		}
	}
	
	public void LPSarray(String pattern, int M, int lps[]) {
		// length of previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0;
		
		while (i < M) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			
			else {
				if (len != 0) {
					len = lps[len - 1];
				}
				
				else {
					lps[i] = len;
					i++;
				}
			}
		}
	}
}

