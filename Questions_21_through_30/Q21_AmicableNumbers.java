package ProjectEuler.Questions_21_through_30;

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
 * Answer:
 */

public class Q21_AmicableNumbers {
	
	private Set<Integer> AmicableNumbers;
	
	public static void main(String[] args) {
		for (int i = 1; i <= 10000; i++) {
			int max = (int) Math.round(Math.sqrt(i));
			int min = (int) Math.round(Math.sqrt(max));
			int sum = 1 + max;
			for (int j = min; j <= max; j++) {
				
			}
		}
	}

}
