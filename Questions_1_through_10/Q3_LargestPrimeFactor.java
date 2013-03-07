package ProjectEuler.Questions_1_through_10;

/*
 * Question #3
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29
 * 
 * Question: What is the largest prime factor of the number 600851475143?
 * Answer: 6857
 */

public class Q3_LargestPrimeFactor {
	
	private static final long MAX = 600851475143L;
	
	public static void main(String[] args) {
		long prime = findLargestPrime(MAX);
		System.out.println("Largest Prime: " + prime);
	}
	
	private static Long findLargestPrime(long n) {
		for (long l = 2; l <= (long) Math.round(Math.sqrt(n)); l++) {	//Iterate up to the sqrt of n
			if (n % l == 0) {
				return findLargestPrime(n/l);	// Pulls out the smallest divisor of n
			}
		}
		return n;
	}
}
