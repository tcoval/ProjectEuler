package ProjectEuler.Questions_91_through_100;

/*
 * Question #92
 * 
 * A number chain is created by continuously adding the square of the digits 
 * in a number to form a new number until it has been seen before.
 * 
 * For example:
 * 44 -> 32 -> 13 -> 10 -> 1 -> 1
 * 85 -> 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89
 * 
 * Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. 
 * What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.
 * 
 * Question: How many starting numbers below ten million will arrive at 89?
 * Answer: 8581146
 */

public class Q92_SquareDigitChain {

	private static final int TARGET = 89;
	private static final int MAX = 10000000; 
	
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= MAX; i++) {
			int value = i;
			while (value != TARGET && value != 1) {
				int sum = 0;
				while (value > 0) {
					int digit = value % 10;
					value /= 10;
					sum += digit * digit;
				}
				value = sum;
			}
			if (value == TARGET) {
				count++;
			}
		}
		System.out.println("Count: " + count);
	}
	
}
