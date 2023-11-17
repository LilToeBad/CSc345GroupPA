/* Author: Aria Kelley
*  File: KMP.java
*  Purpose: This file implementa a KMP pattern searching algorithm
*/
public class KMP {
public static void main(String[] args) {
		String[] patterns = {"abc", "like", "fear", "w", "the"};
		
		String[] texts = {"abcdabcdabcabdbadb", 
				"I do not like them in a house. \n"
				+ "I do not like them with a mouse. \n"
				+ "I do not like them here or there. \n"
				+ "I do not like them anywhere. \n"
				+ "I do not like green eggs and ham. \n"
				+ "I do not like them, Sam-I-Am.", 
				"I must not fear. Fear is the mind-killer. Fear is the little-death that brings total obliteration. \nI will face my fear. I will permit it to pass over me and through me. \nAnd when it has gone past I will turn the "
				+ "inner eye to see its path. \nWhere the fear has gone there will be nothing. Only I will remain.", 
				"The most merciful thing in the world, I think, is the inability of the human mind to correlate \nall its contents. We live on a placid island of ignorance in the midst of black seas of infinity, \nand it was not meant "
				+ "that we should voyage far. The sciences, \neach straining in its own direction, have hitherto harmed us little; \nbut some day the piecing together of dissociated knowledge will open up such terrifying vistas of reality, \nand "
				+ "of our frightful position therein, that we shall either go mad from \nthe revelation or flee from the deadly light into the peace and safety of a new dark age.", 
				"Dorothy lived in the midst of the great Kansas prairies, with Uncle Henry, who was a farmer, \nand Aunt Em, who was the farmer's wife. Their house was small, for the lumber to build it \nhad to be carried by wagon "
				+ "many miles. There were four walls, \na floor and a roof, which made one room; and this room contained a rusty looking \ncooking stove, a cupboard for the dishes, a table, three or four chairs, and the beds.\nUncle Henry and "
				+ "Aunt Em had a big bed in one corner, and Dorothy a little bed in another corner. \nThere was no garret at all, and no cellar—except a small hole, dug in the ground, called a cyclone cellar, \nwhere the family could go in case "
				+ "one of those great whirlwinds arose, mighty enough to crush \nany building in its path. It was reached by a trap-door in the middle of the floor, \nfrom which a ladder led down into the small, dark hole."};
		
		System.out.println("Searching for patterns...");
		
		for (int i = 0; i < 5; i++) {
			String pattern = patterns[i];
			pattern = pattern.toLowerCase();
			System.out.println("pattern: " + pattern);
			
			String text = texts[i];
			text = text.toLowerCase();
			System.out.println("text: " + text);
			
			new KMP().KMPSearch(pattern, text);
			
			System.out.println("All done!");
			System.out.println("----------------------------------");
		}

	}
	
	public void KMPSearch(String pattern, String text) {
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
			
			// pattern fully found
			if (j == m) {
				System.out.println("Pattern found at index " + (i - j) + ".");
				j = lps[j - 1];
			}
			
			// mismatch after j matches
			else if (i < n && pattern.charAt(j) != text.charAt(i)) {
				if (j != 0) {
					j = lps[j - 1];
				}
				else {
					i = i + 1;
				}
			}
		}
	}
	
	public void LPSarray(String pattern, int m, int lps[]) {
		// length of previous longest prefix suffix
		int i = 1;
		int j = 0;
		lps[0] = 0;
		
		while (i < m) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			}
			
			else {
				if (j != 0) {
					j = lps[j - 1];
				}
				
				else {
					lps[i] = j;
					i++;
				}
			}
		}
	}
}

