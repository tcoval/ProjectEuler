package ProjectEuler.Questions_1_through_10;

/*
 * Question #9
 * 
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for 
 * which, a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * 
 * Question: Find the product a*b*c.
 * Answer: 31875000
 */

public class Q9_SpecialPythagoreanTriplet {

	private static final int SUM = 1000;
	
	public static void main(String[] args) {
		boolean found  = false;
		int a = 0, b = 0, c = 0;
		for (c = 333; c < SUM-2; c++) {
			for (b = c-1; b > getA(b, c); b--) {
				a = getA(b,c);
				if (c*c == a*a + b*b) {
					found = true;
					break;
				}
			}
			if (found) {
				break;
			}
		}
		int product = a*b*c;
		System.out.println("Product of Sides: " + product);
	}
	
	private static int getA(int b, int c) {
		return 1000-b-c;
	}
}
