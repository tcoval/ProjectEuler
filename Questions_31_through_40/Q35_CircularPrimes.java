package ProjectEuler.Questions_31_through_40;

import java.util.Arrays;

/*
 * Question #35
 * 
 * The number, 197, is called a circular prime because all rotations of the digits:
 * 
 * 197, 971, and 719, are themselves prime.
 * 
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97.
 * 
 * Question: How many circular primes are there below one million?
 * Answer: 
 */

public class Q35_CircularPrimes {

	private static final int MAX = 1000000;
	private static final boolean[] sieve = new boolean[MAX]; 
	
	public static void main(String[] args) {
		generateGrid();
		int count = 0;
		for (int i = 1; i < MAX; i++) {
			String number = "" + i;
			boolean flag = true;
			do {
				if (!sieve[Integer.parseInt(number)-1]) {
					flag = false;
					break;
				}
				number = shiftDigits(number);
			} while (i != Integer.parseInt(number));
			if (flag) {
				count++;
			}
		}
		System.out.println("Number of primes: " + count);
	}
	
	private static void generateGrid() {
		Arrays.fill(sieve, true);
		sieve[0] = false;
		for (int i = 2; i < Math.sqrt(MAX); i++) {
			for (int j = 2*i; j < MAX; j += i) {
				sieve[j-1] = false;
			}
		}
	}
	
	private static String shiftDigits(String number) {
		return number.charAt(number.length()-1) + number.substring(0,number.length()-1);
	}
}
