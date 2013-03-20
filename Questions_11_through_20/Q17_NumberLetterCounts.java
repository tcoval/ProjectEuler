package ProjectEuler.Questions_11_through_20;

/*
 * Question #17
 * 
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there 
 * are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, 
 * how many letters would be used?
 * 
 * Note: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) 
 * contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of 
 * "and" when writing out numbers is in compliance with British usage.
 * 
 * (My solution is correct for any number up to 1000)
 * 
 * Question: Find the sum of all the primes below two million.
 * Answer: 21124
 */

public class Q17_NumberLetterCounts {
	
	private static final int MAX = 1000;
	private static final String HUNDRED = "hundred";
	private static final String THOUSAND = "thousand";
	private static final String[] TENS = {"","ten","twenty","thirty","forty","fifty",
		"sixty","seventy","eighty","ninety"};
	private static final String[] UNIQUES = {"","one","two","three","four","five","six",
		"seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen",
		"sixteen","seventeen","eighteen","nineteen"};

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < MAX; i++) {
			int ones = i % 10;
			int tens = (i / 10) % 10;
			int hundreds = (i/100) % 10;
			if (hundreds > 0) {
				sum += UNIQUES[hundreds].length() + HUNDRED.length();
				if (tens != 0 || ones != 0) {
					sum += "and".length();
				}
			}
			if (tens >= 2) {
				sum += TENS[tens].length();
				sum += UNIQUES[ones].length();
			} else if (tens == 1) {
				sum += UNIQUES[10 + ones].length();
			} else {
				sum += UNIQUES[ones].length();
			}
		}
		if (MAX == 1000) {
			sum += UNIQUES[1].length() + THOUSAND.length();
		}
		System.out.println("Sum of letters: " + sum);
	}	
}
