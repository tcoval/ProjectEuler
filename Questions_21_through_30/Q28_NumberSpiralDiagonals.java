package ProjectEuler.Questions_21_through_30;

/*
 * Question #28
 * 
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 
 * spiral is formed as follows:
 * 
 * 21 22 23 24 25
 * 20 07 08 09 10
 * 19 06 01 02 11
 * 18 05 04 03 12
 * 17 16 15 14 13
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * Question: What is the sum of the numbers on the diagonals in a 1001 by 
 * 1001 spiral formed in the same way?
 * Answer: 669171001
 */

public class Q28_NumberSpiralDiagonals {

	private static final int MAX = 500;
	
	public static void main(String[] args) {
		int number = 1;
		int mod = 2;
		int total = number;
		for (int level = 0; level < MAX; level++) {
			for (int position = 0; position < 4; position++) {
				number += mod;
				total += number;
			}
			mod += 2;
		}
		System.out.println("Sum of numbers: " + total);
	}
}
