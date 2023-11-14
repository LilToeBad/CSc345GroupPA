import java.util.Random;
import java.util.random.*;
import java.math.*;
import java.util.Scanner;

public class RabinKarpTest {
	
	public static int testCount = 1;							                        // Count the total number of tests
	
	public static void main(String[] args){
		
		System.out.println("------------------------");
		// Call Test 1
		Test_01(null, "This test cass will only print this", (int)Math.random());
		
		// Call Test 2
		Test_01("Pattern", null, (int)Math.random());
		
		// Call Test 3
		Test_01("Hello World", "Goodbye World", (int)Math.random());
		
		// Call Test 4
		Test_01("Refill", "Filler", (int)Math.random());
		
		// Call Test 5
		Test_01("AB", "AABAABABABBAABAABBBAABAABABBA", (int)Math.random());
		
		// Call Test 6
		Test_01("Wake up, it's time for school", "Wake up, it's time for school", (int)Math.random());
		
		// Call Test 7
		Test_01("bee", "I saw a bee on a flower petal this morning", (int)Math.random());
		
		// Call Test 8
		Test_01("Pattern is longer than text sequence", "Text sequence is shorter", (int)Math.random());
		
		// Call Test 9
		Test_02((int)Math.random());
		
		// Call Test 10
		Test_02((int)Math.random());
		
		// Call Test 11
		Test_03((int)Math.random());
		
		// Call Test 12
		Test_03((int)Math.random());
		
		// Call Test 13
		Test_04((int)Math.random());
		
		// Call Test 14
		Test_01(" ", "J u s t a w h o l e b u n c h o f s p a c e s ", (int)Math.random());
		
	}

	
	/* The method findPrime finds the next prime value 
	 * to use for the hash code in the RabinKarpMethod.
	 * The prime value is found by incrementing the 
	 * number passed in by 1 until the next prime number 
	 * is found.
	 */
	public static int findPrime(int number) {
        if (isPrime(number)) {									                      // Checks if current number is prime
            return number;										                        // Return that number
        } else {
            int nextNumber = number + 1;					                  	// Go to the next number
            while (!isPrime(nextNumber)) {						                // Loop the continuing numbers until the next prime is found
                nextNumber++;
            }
            return nextNumber;									                      // Return the newly found prime number
        }
    }

	
	/* The method isPrime checks if the current number
	 * passed into the given method is prime. If the
	 * number is prime, return true, if not return
	 * false.
	 */
    private static boolean isPrime(int number) {
        if (number <= 1) {										                        // Handles if number == 0 || 1
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {								                    // Checks if the current i divides the N-1 evenly, if so it's composite so return false
                return false;
            }
        }
        return true;											                            // Otherwise if prime, return true.
    }
    
    
    /* This method generates a random character from
     * a passed in string. This method is used locally
     * to generate more test cases off of random input
     * from a given string. 
     */
    public static char randomChar(String str) {
        Random random = new Random();							                    // Creates a random object
        int index = random.nextInt(str.length());				              // Gets a random index from the string
        return str.charAt(index);								                      // Get the current character from the random index.
    }

	
    /* This method performs one kind of test of
     * the RabinKarpMethod. this method has a provided
     * pattern input, text input, and prime input.
     */
	public static void Test_01(String pattern, String text, int prime){

		System.out.println("Starting test number " + testCount + ".\n");
		
		RabinKarpMethod method = new RabinKarpMethod();
		prime = findPrime(prime);
		method.search(pattern, text, prime);
		
		testCount++;
		System.out.println("------------------------");
	}
	
	/* This method performs another kind of test of
	 * the RabinKarpMethod. It generates a random
	 * pattern sequence of size 1, a random text
	 * sequence of size 50, and a random prime
	 * number.
	 */
	public static void Test_02(int prime){
		
		System.out.println("Starting test number " + testCount + ".\n");
	
		String pattern = "";
		String text = "";
		
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		RabinKarpMethod method = new RabinKarpMethod();
		prime = findPrime(prime);
		
		for (int i = 0; i < 1; i++){
			pattern += String.valueOf(randomChar(letters));
		}
		
		for (int i = 0; i < 50; i++){
			text += String.valueOf(randomChar(letters));
		}
		
		method.search(pattern, text, prime);
		testCount++;
		System.out.println("------------------------");
		
	}
	
	/* This method performs another kind of test of
	 * the RabinKarpMethod. It generates a random
	 * pattern sequence of size 2, a random text
	 * sequence of size 50, and a random prime
	 * number.
	 */
	public static void Test_03(int prime){
		
		System.out.println("Starting test number " + testCount + ".\n");
	
		String pattern = "";
		String text = "";
		
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		RabinKarpMethod method = new RabinKarpMethod();
		prime = findPrime(prime);
		
		for (int i = 0; i < 2; i++){
			pattern += String.valueOf(randomChar(letters));
		}
		
		for (int i = 0; i < 50; i++){
			text += String.valueOf(randomChar(letters));
		}
		
		method.search(pattern, text, prime);
		testCount++;
		System.out.println("------------------------");
		
	}
	
	/* This method performs another kind of test of
	 * the RabinKarpMethod. It generates a random
	 * pattern sequence of size 1, a random text
	 * sequence of size 100, and a random prime
	 * number.
	 */
	public static void Test_04(int prime){
		
		System.out.println("Starting test number " + testCount + ".\n");
	
		String pattern = "";
		String text = "";
		
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		RabinKarpMethod method = new RabinKarpMethod();
		prime = findPrime(prime);
		
		for (int i = 0; i < 1; i++){
			pattern += String.valueOf(randomChar(letters));
		}
		
		for (int i = 0; i < 100; i++){
			text += String.valueOf(randomChar(letters));
		}
		
		method.search(pattern, text, prime);
		testCount++;
		System.out.println("------------------------");
		
	}
	
	/* This method performs another kind of test of
	 * the RabinKarpMethod. It takes in input from
	 * the user to assign it to the pattern field,
	 * the text field, and the prime field. 
	 * This method is not called in main but can
	 * be.
	 */
	public static void Test_05(){
		
		System.out.println("Starting test number " + testCount + ".\n");
	
		Scanner readUser = new Scanner(System.in);
		boolean answer = false;
		
		System.out.print("Would you like to do your own searches? [Y/N}: ");
		if (readUser.nextLine().equals("Y")) {answer = true;}
		
		while (answer != false){
			System.out.println("Enter a pattern to search a sequence: ");
			String pattern = readUser.nextLine();
			
			System.out.print("Provide a text sequence you want to search: ");
			String text = readUser.nextLine();
			
			System.out.print("Finally, provide an integer: ");
			int prime = readUser.nextInt();
			
			RabinKarpMethod method = new RabinKarpMethod();
			prime = findPrime(prime);
			
			method.search(pattern, text, prime);
			System.out.print("Would you like to do another search? [Y/N]: ");
			if (readUser.nextLine().equals("N")) {answer = false;}
			continue;
		}
		
		testCount++;
		System.out.println("------------------------");
		
	}


}
