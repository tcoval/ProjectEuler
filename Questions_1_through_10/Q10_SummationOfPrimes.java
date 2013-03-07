package ProjectEuler.Questions_1_through_10;

import java.util.Arrays;

/*
 * Question #10
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Question: Find the sum of all the primes below two million.
 * Answer: 142913828922
 */

public class Q10_SummationOfPrimes {

	private static final int MAX = 2000000;
	private static boolean[] primeGrid;
	
	public static void main(String[] args) {
		primeGrid = new boolean[MAX];
		Arrays.fill(primeGrid, true);
		primeGrid[0] = false;
		int iterMax = (int) Math.sqrt(MAX)+1;
		for (int i = 2; i <= iterMax; i++) {
			for (int index = 2*i; index <= MAX; index += i) {
				primeGrid[index-1] = false;
			}
		}
		long sum = 0L;
		for (int i = 0; i < MAX; i++) {
			if (primeGrid[i]) {
				sum += (i + 1);
			}
		}
		System.out.println("Sum of Primes: " + sum);
	}
}
