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

	public static void main(String[] args) {
		Set<Integer> multiples = new HashSet<Integer>();
		int sum = 0;
		//Search through multiples of 3 and add them to the set
		for (int i = 3; i < 1000; i += 3) {
			multiples.add(i);
		}
		//Search through multiples of 5 and add them to the set 
		//if they are not already in the set
		for (int i = 5; i < 1000; i += 5) {
			if (!multiples.contains(i)) {
				multiples.add(i);
			}
		}
		Iterator<Integer> iter = multiples.iterator();
		while (iter.hasNext()) {
			sum += iter.next();
		}
		System.out.println("Sum = " + sum);
	}
}
