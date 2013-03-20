package ProjectEuler.Questions_11_through_20;

/*
 * Question #15
 * 
 * Starting in the left corner of a 2x2 grid, and only being 
 * able to move to the right and down, there are exactly 6 
 * routes to the bottom right corner.
 * 
 * Question: How many such routes are there through a 20x20 grid?
 * Answer: 137846528820
 * 
 * Note: I went with this more complicated solution because of its scalability and
 * also the fact that the long value overflows and I didn't want to use the BigInteger 
 * class. It can quickly calculate the number of paths up until the java long primitive
 * overflows.
 */

public class Q15_LatticePaths {

	// Grid dimensions
	private static final int HEIGHT = 20;
	private static final int WIDTH = 20;
	
	public static void main(String[] args) {
		// Initialize to 1 as to not multiply by 0
		long numPaths = 1;
		// Factors of the numerator which is the factorial of HEIGHT + WIDTH
		int[] numerator = findFactorsofFactorial(HEIGHT + WIDTH);
		int[] denom1 = findFactorsofFactorial(HEIGHT);
		int[] denom2 = findFactorsofFactorial(WIDTH);
		// For each possible base (integers lower than HEIGHT + WIDTH) find the
		// sum of the numerators power subtracting the denominators powers.
		// Increase or decrease numPaths as specified by the determined base and
		// power.
		for (int i = 1; i < HEIGHT+WIDTH; i++) {
			int pow = numerator[i] - (denom1[i] + denom2[i]);
			if (pow > 0) {
				numPaths *= Math.pow(i+1, pow);
			} else {
				numPaths /= Math.pow(i+1, pow);
			}
		}
		System.out.println("The Number of Possible Paths: " + numPaths);
	}
	
	// returns an integer array with the count of occurrences of a given base
	// within the factorial product of n.
	private static int[] findFactorsofFactorial(int n) {
		int[] digits = new int[HEIGHT + WIDTH];
		for (int i = n; i > 0; i--) {
			findFactors(i, digits);
		}
		return digits;
	}
	
	// Given an integer array of length >= n it finds the next largest factor of the
	// integer n and iterates the occurrence of that base in the array by 1.
	private static void findFactors(int n, int[] digits) {
		int limit = (int) Math.round(Math.sqrt(n));
		boolean prime = true;
		for (int i = 2; i <= limit; i++) {
			if (n % i == 0) {
				findFactors(n/i, digits);
				digits[i-1]++;
				prime = false;
				break;
			}
		}
		if (prime) {
			digits[n-1]++;
		}
	}
}
