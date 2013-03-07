package ProjectEuler.Questions_1_through_10;

/*
 * Question #5
 * 
 * 2520 is the smallest number that can be divided by each of the numbers 
 * from 1 to 10 without any remainder.
 * 
 * Question: What is the smallest positive number that is evenly 
 * divisible by all of the numbers from 1 to 20?
 * Answer: 232792560
 */

public class Q5_SmallestMultiple {

	private static final int MAX = 20;
	
	public static void main(String[] args) {
		boolean divisible = false;
		int n = 0;
		while (!divisible) {
			n += MAX;
			divisible = true;
			for (int i = 19; i > 2; i--) {
				if (n % i != 0) {
					divisible = false;
					break;
				}
			}
		}
		System.out.println("Smallest Mulitple: " + n);
	}
}
