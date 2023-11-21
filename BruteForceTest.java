/* Author: Kristin Piorkowski
 * Class: BruteForceTest
 * Purpose: This class implements the brute force algorithm tests
 * to search for a pattern in a string.
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//Rename the import PatternSearch.BruteForce; match your local package.
//If you're in a package import [Package Name].PatternSearch.BruteForce;
//If you're not in a package, just import PatternSearch.BruteForce;.
import PatternSearch.BruteForce;

class BruteForceTest {

	//////
	// All tests where pattern was found in string
	//////

	public static void main(){
		test1a();
		test2a();
		test3a();
		test4a();
		test5a();
		test6a();
		test7a();
		test8a();
		test9a();
		test10a();
		test1b();
		test2b();
		test3b();
		test4b();
		test5b();
		test6b();
		test7b();
		test8b();
		test9b();
		test10b();
		test1c();
		test2c();
		test3c();
		test4c();
		test5c();
		test6c();
		test7c();
		test8c();
		test9c();
		test10c();
	}
	
	@Test
	static void test1a() {
		String input = "Hi my name is Bob";
		String pattern = "my";
		assertEquals("Pattern found", BruteForce.search(input, pattern));
		
	}

	@Test
	static void test2a() {
		String input = "I go to the University of Arizona";
		String pattern = "Arizona";
		assertEquals("Pattern found", BruteForce.search(input, pattern));
	}

	@Test
	static void test3a() {
		String input = "I work at HoneyWell and I like Honey";
		String pattern = "Honey";
		assertEquals("Pattern found", BruteForce.search(input, pattern));
	}

	@Test
	static void test4a() {
		String input = "AB ABBACABA BAA";
		String pattern = "ABA";
		assertEquals("Pattern found", BruteForce.search(input, pattern));
	}

	@Test
	static void test5a() {
		String input = "ABABA ADBBCB ABD DABA ABBADA";
		String pattern = "DA";
		assertEquals("Pattern found", BruteForce.search(input, pattern));
	}

	@Test
	static void test6a() {
		String input = "Sally sells seashells by the seashore she sells";
		String pattern = "sells";
		assertEquals("Pattern found", BruteForce.search(input, pattern));
	}

	@Test
	static void test7a() {
		String input = "Sally sells seashells by the seashore she sells";
		String pattern = "sea";
		assertEquals("Pattern found", BruteForce.search(input, pattern));
	}

	@Test
	static void test8a() {
		String input = "--++ -+-+ -+ ---+++ +-- +- -+-+-";
		String pattern = "+-";
		assertEquals("Pattern found", BruteForce.search(input, pattern));
	}

	@Test
	static void test9a() {
		String input = "13 31 24 42 35 53 46 64 57 75 46 64 34 78 64 57 46 35 24 42";
		String pattern = "46";
		assertEquals("Pattern found", BruteForce.search(input, pattern));
	}

	@Test
	static void test10a() {
		String input = " a a b b c c d d e e";
		String pattern = " ";
		assertEquals("Pattern found", BruteForce.search(input, pattern));
	}

	//////
	// All tests where pattern was not found in string
	//////

	@Test
	static void test1b() {
		String input = "Hi my name is Bob";
		String pattern = "Alice";
		assertEquals("Pattern not found", BruteForce.search(input, pattern));
	}

	@Test
	static void test2b() {
		String input = "I go to the University of Arizona";
		String pattern = "arizona";
		assertEquals("Pattern not found", BruteForce.search(input, pattern));
	}

	@Test
	static void test3b() {
		String input = "I work at HoneyWell and I like Honey";
		String pattern = "honey";
		assertEquals("Pattern not found", BruteForce.search(input, pattern));
	}

	@Test
	static void test4b() {
		String input = "AB ABBACABA BAA";
		String pattern = "AAA";
		assertEquals("Pattern not found", BruteForce.search(input, pattern));
	}

	@Test
	static void test5b() {
		String input = "ABABA ADBBCB ABD DABA ABBADA";
		String pattern = "AAD";
		assertEquals("Pattern not found", BruteForce.search(input, pattern));
	}

	@Test
	static void test6b() {
		String input = "Sally sells seashells by the seashore she sells";
		String pattern = "sandy";
		assertEquals("Pattern not found", BruteForce.search(input, pattern));
	}

	@Test
	static void test7b() {
		String input = "Sally sells seashells by the seashore she sells";
		String pattern = "sure";
		assertEquals("Pattern not found", BruteForce.search(input, pattern));
	}

	@Test
	static void test8b() {
		String input = "--++ -+-+ -+ ---+++ +-- +- -+-+-";
		String pattern = "++--";
		assertEquals("Pattern not found", BruteForce.search(input, pattern));
	}

	@Test
	static void test9b() {
		String input = "13 31 24 42 35 53 46 64 57 75 46 64 34 78 64 57 46 35 24 42";
		String pattern = "47";
		assertEquals("Pattern not found", BruteForce.search(input, pattern));
	}

	@Test
	static void test10b() {
		String input = " a a b b c c d d e e";
		String pattern = "  ";
		assertEquals("Pattern not found", BruteForce.search(input, pattern));
	}

	//////
	// All tests where string length was smaller than pattern
	//////

	@Test
	static void test1c() {
		String input = "Hi";
		String pattern = "Bob";
		assertEquals("String length smaller than pattern", BruteForce.search(input, pattern));
	}

	@Test
	static void test2c() {
		String input = "";
		String pattern = " ";
		assertEquals("String length smaller than pattern", BruteForce.search(input, pattern));
	}

	@Test
	static void test3c() {
		String input = "ab";
		String pattern = "abbabba";
		assertEquals("String length smaller than pattern", BruteForce.search(input, pattern));
	}

	@Test
	static void test4c() {
		String input = "AB";
		String pattern = "Arizona";
		assertEquals("String length smaller than pattern", BruteForce.search(input, pattern));
	}

	@Test
	static void test5c() {
		String input = " ";
		String pattern = "  ";
		assertEquals("String length smaller than pattern", BruteForce.search(input, pattern));
	}

	@Test
	static void test6c() {
		String input = "!^&&^!";
		String pattern = "  !^&&^!  ";
		assertEquals("String length smaller than pattern", BruteForce.search(input, pattern));
	}

	@Test
	static void test7c() {
		String input = " aa bb";
		String pattern = "  aaa  ";
		assertEquals("String length smaller than pattern", BruteForce.search(input, pattern));
	}

	@Test
	static void test8c() {
		String input = "--++ -+-+ -+";
		String pattern = "--++ -+-+ -+ ";
		assertEquals("String length smaller than pattern", BruteForce.search(input, pattern));
	}

	@Test
	static void test9c() {
		String input = "1";
		String pattern = " 1 ";
		assertEquals("String length smaller than pattern", BruteForce.search(input, pattern));
	}

	@Test
	static void test10c() {
		String input = "Hi";
		String pattern = "Howdy";
		assertEquals("String length smaller than pattern", BruteForce.search(input, pattern));
	}	
}
