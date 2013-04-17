package ProjectEuler.Questions_21_through_30;

import java.util.ArrayList;
import java.util.List;

/*
 * Question #24
 * 
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible
 * permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically
 * or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 
 * and 2 are:
 * 012 021 102 120 201 210
 * 
 * Question: What is the millionth lexicographic permutation of the 
 * digits 0, 1, 2, 3, 4, 5, 6, 7, 8, 9?
 * Answer: 2783915460
 */

public class Q24_LexicographicPermutations {

	public static List<Integer> digits;
	public static int placement = 1000000;
	
	public static void main(String[] args) {
		placement -= 1;
		initDigits();
		long num = 0;
		while (!digits.isEmpty()) {
			num *= 10;
			num += getNextDigit();
		}
		System.out.println("1,000,000th permutation: " + num);
	}
	
	private static int getNextDigit() {
		int mod = 1;
		for (int i = digits.size(); i > 1; i--) {
			mod *= i;
		}
		mod /= digits.size();
		int index = placement / mod;
		placement -= index * mod;
		return digits.remove(index);
	}
	
	private static void initDigits() {
		digits = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			digits.add(i);
		}
	}
}
