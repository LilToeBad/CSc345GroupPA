
//Rename the import PatternSearch.boyerMethod; match your local package.
//If you're in a package import [Package Name].PatternSearch.KMP;
//If you're not in a package, just import PatternSearch.boyerMethod;.
import PatternSearch.boyerMethod;

//Sasha Joe
//CSC 345, Fall '23
//testCasesBoyer.java for boyerMethod.java for team project

public class testCasesBoyer {
	public static void main() {
		
		char[] test1Text = "ABAABCD".toCharArray();
		char[] test1Pattern = 	"ABC".toCharArray();
		
		char[] test2Text = "Happy Birthday Poppy".toCharArray();
		char[] test2Pattern = "ppy".toCharArray();
		
		char[] test3Text = "No pattern was found".toCharArray();
		char[] test3Pattern = "lmnop".toCharArray();
		
		boyerMethod.search(test1Text, test1Pattern);
		boyerMethod.search(test2Text, test2Pattern);
		boyerMethod.search(test3Text, test3Pattern);

	}
}
