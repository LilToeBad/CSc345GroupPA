package teamProject;

// Sasha Joe
// CSC 345, Fall '23
// boyerMethod.java for team project


public class boyerMethod {
	
	static int[] badCharacters = new int[256];

	public static void search(char[] string, char[] pattern){
		checkBadCharHeuristics(pattern);
		
		int numOfShifts = 0;
		
		while((string.length - pattern.length) >= numOfShifts) { // potential alignments
			// System.out.println("inside first wile loop");
			
			int matchingIndexNum = pattern.length-1;
			
			while(matchingIndexNum >= 0 && pattern[matchingIndexNum] == string[numOfShifts+matchingIndexNum]) {
				// System.out.println("inside second while loop");
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
