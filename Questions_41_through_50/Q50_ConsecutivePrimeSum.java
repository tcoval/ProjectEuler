package ProjectEuler.Questions_41_through_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q50_ConsecutivePrimeSum {

	private static final int MAX = 100;
	private static boolean[] primes;
	
	public static void main(String[] args) {
		int bounds = (int) Math.sqrt(MAX) + 1;
		primes = generatePrimes(bounds);
		List<Integer> primeNumbers = new ArrayList<Integer>();
		for (int i = 2; i < MAX; i++) {
			if (primes[i-1]) {
				primeNumbers.add(i);
			}
		}
		int maxCount = 0, prime = 0;
		for (int start = 0; start < primeNumbers.size(); start++) {
			int sum = 0, count = 0, i = 0;
			while ((sum < MAX) && (start + i < primeNumbers.size())) {
				if (primeNumbers.contains(sum)) {
					maxCount = Math.max(maxCount, count);
					if (maxCount == count) {
						prime = sum;
					}
				} else {
					count = 0;
					sum = 0;
				}
				sum += primeNumbers.get(start + i);
				count++;
				i++;
			}
			
		}
		System.out.println("Prime of Most Consecutive Sums: " + prime);
	}
	
	private static boolean[] generatePrimes(int max) {
		boolean[] primes = new boolean[MAX];
		Arrays.fill(primes, true);
		for (int i = 2; i <= max; i++) {
			for (int index = 2 * i; index < MAX; index += i) {
				if (primes[index - 1]) {
					primes[index - 1] = false;
				}
			}
		}
		return primes;
	}
}
