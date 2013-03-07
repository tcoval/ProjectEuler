package ProjectEuler.Questions_1_through_10;

/*
 * Question #4
 * 
 * A palindromic number read the same both ways. The largest palindrome made 
 * from the product of two 2-digit numbers is 9009 = 91 * 99.
 * 
 * Question: Find the largest palindrome made from the product of two 3-digit numbers.
 * Answer: 906609
 */

public class Q4_LargestPalindromeProduct {

	private static final int MIN = 100;
	private static final int MAX = 1000;
	
	public static void main(String[] args) {
		int largestPalindrome = 0;
		for (int i = MIN; i < MAX; i++) {
			for (int j = MIN; j < MAX; j++) {
				int product = i*j;
				if (product == createReverse(product) && product > largestPalindrome) {
					largestPalindrome = product;
				}
			}
		}
		System.out.println("Largest Palindrome: " + largestPalindrome);
	}
	
	private static int createReverse(int n) {
		int reverse = 0;
		while (n != 0) {
			reverse *= 10;
			reverse += n % 10;
			n /= 10;
		}
		return reverse;
	}
}
