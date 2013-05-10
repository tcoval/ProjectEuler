package ProjectEuler.Questions_81_through_90;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Question #89
 * 
 * The rules for writing Roman numerals allow for many ways of writing each number (see About Roman Numerals...). However, there is always a "best" way of writing a particular number.
 *
 * For example, the following represent all of the legitimate ways of writing the number sixteen:
 * 
 * IIIIIIIIIIIIIIII
 * VIIIIIIIIIII
 * VVIIIIII
 * XIIIIII
 * VVVI
 * XVI
 * 
 * The last example being considered the most efficient, as it uses the least number of numerals.
 * 
 * The 11K text file, roman.txt contains one thousand numbers written in valid, but not 
 * necessarily minimal, Roman numerals; that is, they are arranged in descending units 
 * and obey the subtractive pair rule.
 * 
 * Question: Find the number of characters saved by writing each of these in their minimal form.
 * Answer: 
 */

public class Q89_RomanNumerals {

	private static final String encoding = "IVXLCDM";
	private static final Map<Character, Integer> converter = new HashMap<Character, Integer>();
	
	public static void main(String[] args) throws FileNotFoundException {
		createMap();
		Scanner input = new Scanner(new File("roman.txt"));
		int digitsSaved = 0;
		while (input.hasNextLine()) {
			String numeralOriginal = input.nextLine().trim();
			System.out.println(numeralOriginal);
			//String numeralSmallest = toNumeral(number);
			//digitsSaved += numeralOriginal.length() - numeralSmallest.length();
		}
		System.out.println("Characters saved: " + digitsSaved);
	}
	
	private static void createMap() {
		converter.put('I',1);
		converter.put('V',5);
		converter.put('X',10);
		converter.put('L',50);
		converter.put('C',100);
		converter.put('D',500);
		converter.put('M',1000);
		
	}

	/*
	private static String toNumeral(int number) {
		String numeral = "";
		for (int i = values.length - 1; i >= 0; i--) {
			while (number / values[i] > 0) {
				number -= values[i];
				numeral += numerals[i];
			}
		}
		return numeral;
	}
	
	private static int toNumber(String numeral) {
		for 
		return number;
	}
	*/
}
