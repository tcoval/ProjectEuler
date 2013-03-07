package ProjectEuler.Questions_1_through_10;

/*
 * Question #6
 * 
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the first
 * ten natural number and the square of the sum is 3025 - 385 = 2640
 * 
 * Question: Find the difference between the sum of the squares of the
 * first one hundred natural numbers and the square of the sum.
 * Answer: 25164150
 */

public class Q6_SumSquareDifference {

	private static final int MAX = 100;
	
	public static void main(String[] args) {
		int sumOfSquares = getSumOfSquares(MAX);
		int squareOfSums = getSquareOfSums(MAX);
		int difference = squareOfSums - sumOfSquares;
		System.out.println("Sum Square Difference: " + difference);
	}
	
	private static int getSumOfSquares(int n) {
		int[] sumOfSquares = new int[MAX];
		sumOfSquares[0] = 1;
		for (int i = 2; i <= MAX; i++) {
			sumOfSquares[i-1] = sumOfSquares[i-2] + (i*i);
		}
		return sumOfSquares[MAX-1];
	}
	
	private static int getSquareOfSums(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum*sum;
	}
}
