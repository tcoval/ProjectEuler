package ProjectEuler.Questions_61_through_70;

import java.math.BigInteger;

/*
 * Question #65
 * 
 * The square root of 2 can be written as an infinite continued fraction.
 * 
 * sqrt(2) = 1 + 1/(2+1/(2+1/(2+1/(2+1/(2+...)))))
 * 
 * The infinite continued fraction can be written, sqrt(2) = [1;(2)], (2) indicates that 2 
 * repeats "ad infinitum". In a similar way, sqrt(23) = [4;(1,3,1,8)].
 * 
 * It turns out that the sequence of partial values of continued fractions for square roots 
 * provide the best rational approximations. Let us consider the convergents of sqrt(2).
 * 
 * 1 + (1/2) = 3/2
 * 1 + 1/(2+1/2) = 7/5
 * 1 + 1/(2+1/(2+1/2)) = 17/12
 * 1 + 1/(2+1/(2+1/(2+1/2))) = 41/29
 * 
 * Hence the sequence of the first ten convergents for sqrt(2) are:
 * 
 * 1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...
 * 
 * What is most surprising is that the important mathematical 
 * constant, e = [2; 1,2,1, 1,4,1, 1,6,1, ... , 1,2k,1, ...].
 * 
 * The first ten terms in the sequence of convergents for e are:
 * 
 * 2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
 * 
 * The sum of digits in the numerator of the 10th convergent is 1 + 4 + 5 + 7 = 17.
 * 
 * Question: Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
 * Answer: 272
 */

public class Q65_ConvergentsOfE {

	public static final int MAX = 100;
	
	public static void main(String[] args) {
		BigInteger numerator = BigInteger.ONE;
		BigInteger denominator = new BigInteger("2");
		BigInteger mod = new BigInteger("2");
		for (int i = 1; i < MAX; i++) {
			if (i % 3 == 2) {
				numerator = numerator.add(denominator.multiply(mod));
				mod = mod.add(new BigInteger("2"));
			} else {
				numerator = numerator.add(denominator);
			}
			BigInteger temp = numerator.add(BigInteger.ZERO);
			numerator = denominator;
			denominator = temp;
		}
		char[] digits = denominator.toString().toCharArray();
		int sum = 0;
		for (char digit : digits) {
			sum += Integer.parseInt("" + digit);
		}
		System.out.println("Sum of digits: " + sum);
	}
}
