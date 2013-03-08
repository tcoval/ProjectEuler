package ProjectEuler.Questions_11_through_20;

/*
 * Question #14
 * 
 * The following iterative sequence is defined for the set of positive integers:
 * n => n / 2 (n is even)
 * n => (3 * n) +1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 => 40 => 20 => 10 => 5 => 16 => 8 => 4 => 2 => 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 
 * 10 terms. Although it has not been proved yet (Collatz Problem), it is thought 
 * that all starting numbers finish at 1.
 * 
 * Question: Which starting number, under one million, produces the longest chain?
 * Answer: 837799
 * 
 * Note: Once the change starts the terms are allowed to go above one million.
 */

public class Q14_LongestCollatzSequence {
	
	private static final long MAX = 1000000L;
	
	public static void main(String[] args) {
		int max = 0;
		long number = 0;
		for (long n = 2L; n < MAX; n++) {
			int tempMax = Math.max(max, collatzSequence(n));
			if (max != tempMax) {
				max = tempMax;
				number = n;
			}
		}
		System.out.println("Starting Number: " + number);
	}
	
	private static int collatzSequence(long n) {
		int count = 1;
		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
				count++;
			} else {
				n = (3 * n) + 1;
				count++;
			}
		}
		return count;
	}
}
