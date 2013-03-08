package ProjectEuler.Questions_1_through_10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * Question #1
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we 
 * get 3, 5, 6 and 9. The sum of these multiples is 23. 
 * 
 * Question: Find the sum of all the multiples of 3 or 5 below 1000.
 * Answer: 233168
 */

public class Q1_MultiplesOf3And5 {

	private static final int MAX = 1000;
	private static final int[] multipliers = {3,5};
	
	public static void main(String[] args) {
		Set<Integer> multiples = new HashSet<Integer>();
		for (int index = 0; index < multipliers.length; index++) {
			int n = multipliers[index];
			for (int i = n; i < MAX; i += n) {
				if (!multiples.contains(i)) {
					multiples.add(i);
				}
			}
		}
		int sum = 0;
		Iterator<Integer> iter = multiples.iterator();
		while (iter.hasNext()) {
			sum += iter.next();
		}
		System.out.println("Sum = " + sum);
	}
}
