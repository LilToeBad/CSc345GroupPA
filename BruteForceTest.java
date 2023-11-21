/* Author: Kristin Piorkowski
 * Class: BruteForceTest
 * Purpose: This class implements the brute force algorithm tests
 * to search for a pattern in a string.
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BruteForceTest {

	private BruteForce algorithm = new BruteForce();

	//////
	// All tests where pattern was found in string
	//////

	@Test
	public void test1a() {
		String input = "Hi my name is Bob";
		String pattern = "my";
		assertEquals("Pattern found", algorithm.search(input, pattern));
	}

	@Test
	void test2a() {
		String input = "I go to the University of Arizona";
		String pattern = "Arizona";
		assertEquals("Pattern found", algorithm.search(input, pattern));
	}

	@Test
	void test3a() {
		String input = "I work at HoneyWell and I like Honey";
		String pattern = "Honey";
		assertEquals("Pattern found", algorithm.search(input, pattern));
	}

	@Test
	void test4a() {
		String input = "AB ABBACABA BAA";
		String pattern = "ABA";
		assertEquals("Pattern found", algorithm.search(input, pattern));
	}

	@Test
	void test5a() {
		String input = "ABABA ADBBCB ABD DABA ABBADA";
		String pattern = "DA";
		assertEquals("Pattern found", algorithm.search(input, pattern));
	}

	@Test
	void test6a() {
		String input = "Sally sells seashells by the seashore she sells";
		String pattern = "sells";
		assertEquals("Pattern found", algorithm.search(input, pattern));
	}

	@Test
	void test7a() {
		String input = "Sally sells seashells by the seashore she sells";
		String pattern = "sea";
		assertEquals("Pattern found", algorithm.search(input, pattern));
	}

	@Test
	void test8a() {
		String input = "--++ -+-+ -+ ---+++ +-- +- -+-+-";
		String pattern = "+-";
		assertEquals("Pattern found", algorithm.search(input, pattern));
	}

	@Test
	void test9a() {
		String input = "13 31 24 42 35 53 46 64 57 75 46 64 34 78 64 57 46 35 24 42";
		String pattern = "46";
		assertEquals("Pattern found", algorithm.search(input, pattern));
	}

	@Test
	void test10a() {
		String input = " a a b b c c d d e e";
		String pattern = " ";
		assertEquals("Pattern found", algorithm.search(input, pattern));
	}

	//////
	// All tests where pattern was not found in string
	//////

	@Test
	public void test1b() {
		String input = "Hi my name is Bob";
		String pattern = "Alice";
		assertEquals("Pattern not found", algorithm.search(input, pattern));
	}

	@Test
	void test2b() {
		String input = "I go to the University of Arizona";
		String pattern = "arizona";
		assertEquals("Pattern not found", algorithm.search(input, pattern));
	}

	@Test
	void test3b() {
		String input = "I work at HoneyWell and I like Honey";
		String pattern = "honey";
		assertEquals("Pattern not found", algorithm.search(input, pattern));
	}

	@Test
	void test4b() {
		String input = "AB ABBACABA BAA";
		String pattern = "AAA";
		assertEquals("Pattern not found", algorithm.search(input, pattern));
	}

	@Test
	void test5b() {
		String input = "ABABA ADBBCB ABD DABA ABBADA";
		String pattern = "AAD";
		assertEquals("Pattern not found", algorithm.search(input, pattern));
	}

	@Test
	void test6b() {
		String input = "Sally sells seashells by the seashore she sells";
		String pattern = "sandy";
		assertEquals("Pattern not found", algorithm.search(input, pattern));
	}

	@Test
	void test7b() {
		String input = "Sally sells seashells by the seashore she sells";
		String pattern = "sure";
		assertEquals("Pattern not found", algorithm.search(input, pattern));
	}

	@Test
	void test8b() {
		String input = "--++ -+-+ -+ ---+++ +-- +- -+-+-";
		String pattern = "++--";
		assertEquals("Pattern not found", algorithm.search(input, pattern));
	}

	@Test
	void test9b() {
		String input = "13 31 24 42 35 53 46 64 57 75 46 64 34 78 64 57 46 35 24 42";
		String pattern = "47";
		assertEquals("Pattern not found", algorithm.search(input, pattern));
	}

	@Test
	void test10b() {
		String input = " a a b b c c d d e e";
		String pattern = "  ";
		assertEquals("Pattern not found", algorithm.search(input, pattern));
	}

	//////
	// All tests where string length was smaller than pattern
	//////

	@Test
	public void test1c() {
		String input = "Hi";
		String pattern = "Bob";
		assertEquals("String length smaller than pattern", algorithm.search(input, pattern));
	}

	@Test
	void test2c() {
		String input = "";
		String pattern = " ";
		assertEquals("String length smaller than pattern", algorithm.search(input, pattern));
	}

	@Test
	void test3c() {
		String input = "ab";
		String pattern = "abbabba";
		assertEquals("String length smaller than pattern", algorithm.search(input, pattern));
	}

	@Test
	void test4c() {
		String input = "AB";
		String pattern = "Arizona";
		assertEquals("String length smaller than pattern", algorithm.search(input, pattern));
	}

	@Test
	void test5c() {
		String input = " ";
		String pattern = "  ";
		assertEquals("String length smaller than pattern", algorithm.search(input, pattern));
	}

	@Test
	void test6c() {
		String input = "!^&&^!";
		String pattern = "  !^&&^!  ";
		assertEquals("String length smaller than pattern", algorithm.search(input, pattern));
	}

	@Test
	void test7c() {
		String input = " aa bb";
		String pattern = "  aaa  ";
		assertEquals("String length smaller than pattern", algorithm.search(input, pattern));
	}

	@Test
	void test8c() {
		String input = "--++ -+-+ -+";
		String pattern = "--++ -+-+ -+ ";
		assertEquals("String length smaller than pattern", algorithm.search(input, pattern));
	}

	@Test
	void test9c() {
		String input = "1";
		String pattern = " 1 ";
		assertEquals("String length smaller than pattern", algorithm.search(input, pattern));
	}

	@Test
	void test10c() {
		String input = "Hi";
		String pattern = "Howdy";
		assertEquals("String length smaller than pattern", algorithm.search(input, pattern));
	}
}
