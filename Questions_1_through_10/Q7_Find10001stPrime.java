package ProjectEuler.Questions_1_through_10;

/*
 * Question #7
 * 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can 
 * see that the 6th prime is 13. 
 * 
 * Question: What is the 10,001st prime number?
 * Answer: 104743
 */

public class Q7_Find10001stPrime {

	public static final int MAX = 10001;
	
	public static void main(String[] args) {
		
		int count = 1;
		int n = 1;
		while (count < MAX) {
			n += 2;
			count++;
			int sqrt = (int) Math.round(Math.sqrt(n));
			for (int i = 2; i <= sqrt; i++) {
				if (n % i == 0) {
					count--;
					break;
				}
			}
		}
		System.out.println("10001st Prime Number: " + n);
	}
}
