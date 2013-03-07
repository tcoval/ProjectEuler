package ProjectEuler.Questions_1_through_10;

import java.util.HashMap;
import java.util.Map;

/*
 * Question #2
 * 
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * 
 * Question: By considering the terms in the Fibonacci sequence whose values do not exceed 4 million, find
 * the sum of the even-valued terms.
 * Answer: 4613732
 */

public class Q2_EvenFibonacciNumbers {
	
	private static Map<Integer, Integer> map;
	private static final int MAX = 4000000;
	
	public static void main(String[] args) {
		map = new HashMap<Integer, Integer>();
		int sum = 0, value = 0, i = 0;
		while (value < MAX) {
			sum += value;
			value = fibo(i*3);	//Every third fibonacci number is even
			i++;
		}
		System.out.println("Sum: " + sum);
	}
	
	private static int fibo(int n) {
		if (map.containsKey(n)) {
			return map.get(n);
		} else if (n < 2) {
			map.put(n,n);
			return n;
		} else {
			map.put(n, fibo(n-1) + fibo(n-2));
			return map.get(n);
		}
	}
}
