package ProjectEuler.Questions_21_through_30;

import java.util.HashSet;
import java.util.Set;

/*
 * Question #21
 * 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 20, 22, 44, 55, 110; therefore d(220) = 284. The proper
 * divisors of 284 are 1, 2, 4, 71, 142; so d(284) = 220.
 * 
 * Question: Evaluate the sum of all the amicable number under 10,000.
 * Answer: 31626
 */

public class Q21_AmicableNumbers {
	
	private static final Set<Integer> AMICABLES = new HashSet<Integer>();
	private static final int MAX = 10000;
	
	public static void main(String[] args) {
		for (int num = 1; num < MAX; num++) {
			if (!AMICABLES.contains(num)) {
				isAmicable(num);
			}
		}
		int totalSum = sumOf(AMICABLES);
		System.out.println(totalSum);
	}
	
	private static void isAmicable(int n) {
		Set<Integer> divisors1 = getDivisors(n);
		int sum1 = sumOf(divisors1);
		Set<Integer> divisors2 = getDivisors(sum1);
		int sum2 = sumOf(divisors2);
		if (sum2 == n && sum1 != n) {
			AMICABLES.add(n);
			if (sum1 < MAX) {
				AMICABLES.add(sum1);
			}
		}
	}
	
	private static Set<Integer> getDivisors(int n) {
		Set<Integer> divisors = new HashSet<Integer>();
		int max = (int) Math.round(Math.sqrt(n));
		divisors.add(1);
		for (int i = 2; i <= max; i++) {
			if (n % i == 0) {
				divisors.add(i);
				divisors.add(n/i);
			}
		}
		return divisors;
	}
	
	private static int sumOf(Set<Integer> set) {
		int sum = 0;
		for (int i : set) {
			sum += i;
		}
		return sum;
	}
}
