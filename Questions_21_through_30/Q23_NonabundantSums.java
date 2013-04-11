package ProjectEuler.Questions_21_through_30;

import java.util.ArrayList;
import java.util.List;

/*
 * Question #23
 * 
 * A perfect number is a number for which the sum of its proper divisors is exactly equal
 * to the number. For example, the sum of the proper divisors of 28 would be 
 * 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than n and it 
 * is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that 
 * can be written as the sum of two abundant numbers is 24. By mathematical analysis, 
 * it can be shown that all integers greater than 28123 can be written as the sum of two 
 * abundant numbers. However, this upper limit cannot be reduced any further by analysis 
 * even though it is known that the greatest number that cannot be expressed as the sum of 
 * two abundant numbers is less than this limit.
 * 
 * Question: Find the sum of all the positive integers which cannot be written as the sum 
 * of two abundant numbers.
 * Answer: 4179871
 */

public class Q23_NonabundantSums {

	private static final int MAX = 28123;
	
	public static void main(String[] args) {
		List<Integer> abundantNumbers = findAbundantNumbers();
		boolean[] possibleSums = new boolean[28123];
		
		for (int num1 : abundantNumbers) {
			for (int num2 : abundantNumbers) {
				int sum = num1 + num2;
				if (sum <= MAX) {
					possibleSums[sum - 1] = true;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < possibleSums.length; i++) {
			if (!possibleSums[i]) {
				sum += i + 1;
			}
		}
		System.out.println("Sum of non-abundant sums: " + sum);
		
	}
	
	private static List<Integer> findAbundantNumbers() {
		List<Integer> abundantNumbers = new ArrayList<Integer>();
		for (int i = 1; i < MAX; i++) {
			int sum = getSumOfFactors(i);
			if (sum > i) {
				abundantNumbers.add(i);
			}
		}
		return abundantNumbers;
	}
	
	private static int getSumOfFactors(int n) {
		int sum = 0;
		for (int i = 1; i <= n/2; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
}
