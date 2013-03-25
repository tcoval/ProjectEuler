package ProjectEuler.Questions_21_through_30;

import java.math.BigInteger;

/*
 * Question #25
 * 
 * The Fibonacci sequence is defined by the recurrence relation:
 * F_n = F_n-1 + F_n-2, where F_1 = 1 and F_2 = 1.
 * Hence the first 6 terms will be:
 * 
 * F_1 = 1
 * F_2 = 1
 * F_3 = 2
 * F_4 = 3
 * F_5 = 5
 * F_6 = 8
 * ...
 * F_12 = 144
 * 
 * The 12th term, F_12 is the first term to contain three digits.
 * 
 * Question: What is the first term in the Fibonacci sequence to contain 1000 digits?
 * Answer: 4782
 */

public class Q25_1000DigitFibonacciNumber {

	private static final BigInteger MAX = BigInteger.TEN.pow(999);
	
	public static void main(String[] args) {
		BigInteger value1 = BigInteger.ONE;
		BigInteger value2 = BigInteger.ONE;
		int term = 2;
		while (value2.compareTo(MAX) < 1) {
			BigInteger sum = value1.add(value2);
			value1 = value2;
			value2 = sum;
			term++;
		}
		System.out.println("Term: " + term);
	}
}
