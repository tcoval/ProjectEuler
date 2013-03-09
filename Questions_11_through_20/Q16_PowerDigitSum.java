package ProjectEuler.Questions_11_through_20;

import java.math.BigInteger;

/*
 * Question #16
 * 
 * 2 ^ 15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * Question: What is the sum of the digits of the number 2 ^ 1000?
 * Answer: 1366
 */

public class Q16_PowerDigitSum {

	private static final int POWER = 1000;
	private static final int BASE = 2;
	
	public static void main(String[] args) {
		BigInteger i = new BigInteger("" + BASE);
		i = i.pow(POWER);
		int sum = 0;
		while (!i.equals(BigInteger.ZERO)) {
			sum += i.mod(BigInteger.TEN).intValue();
			i = i.divide(BigInteger.TEN);
		}
		System.out.println("Sum of Digits: " + sum);
	}
}
