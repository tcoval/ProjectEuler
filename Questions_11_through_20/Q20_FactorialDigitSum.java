package ProjectEuler.Questions_11_through_20;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

/*
 * Question #20
 * 
 * n! means n * (n - 1) * ... * 3 * 2 * 1
 * 
 * For example, 10! = 10 * 9 * ... * 3 * 2 * 1 = 3,628,800
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Question: Find the sum of the digits in the number 100!
 * Answer: 648
 */

public class Q20_FactorialDigitSum {

	private static Map<Integer,BigInteger> factorialValues;
	
	public static void main(String[] args) {
		factorialValues = new TreeMap<Integer,BigInteger>();
		factorialValues.put(1, BigInteger.ONE);
		for (int i = 2; i <= 100; i++) {
			BigInteger value = BigInteger.valueOf(i);
			value = value.multiply(factorialValues.get(i-1));
			factorialValues.put(i, value);
		}
		String number = factorialValues.get(100).toString();
		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			sum += Integer.parseInt("" + number.charAt(i));
		}
		System.out.println("Sum of digits: " + sum);
	}
}
