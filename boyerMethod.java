//Sasha Joe
//CSc 345, Fall '23
//boyerMethod.java

public class boyerMethod{

  public static void search(String[] string, String[] pattern){
    int patternShift = 0;

    int[] nextStrPosition = new int[m + 1];
    int[] numofShifts = new int[m+1];

    for(int i = 0; i < pattern.length(); i++){
      numofShifts[i] = 0;
    }

    checkGoodSuffixHeuristic(nextStrPosition, numofShifts, pattern, pattern.length());

    while((string.length() - pattern.length()) >= patternShift){

      int j = pattern.length();

      while(j >= 0 && pattern[j] == string[patternShift + j]){
        j--;
      }

      if(j < 0){
        patternShift += numofShifts[0];
        System.out.println("Pattern found at shift: " + shift[0]);
      }else{
        patternShift += numofShifts[j+1];
      }
    }
  }

  public static void checkGoodSuffixHeuristic(int[] nextStrPosition, int[] numofShifts, String[] pattern, int length){
    System.out.println("---work n progress---");
    System.out.println("come back later :)");
  }

  public static void checkBadCharHeuristics(String[] string, int length, int[] badCharacters){
    System.out.println("---work n progress---");
    System.out.println("come back later :)");
  }
}
