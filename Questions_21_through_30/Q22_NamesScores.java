package ProjectEuler.Questions_21_through_30;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
 * Question #22
 * 
 * Using names.txt a 46K text file containing over five-thousand first names, begin by 
 * sorting it into alphabetical order. Then working out the alphabetical value for 
 * each name, multiply this value by its alphabetical position in the list to obtain 
 * a name of score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth
 * 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a 
 * score of 938 * 53 = 49714.
 * 
 * Question: What is the total of all the names scores in the file?
 * Answer: 871198282
 */

public class Q22_NamesScores {
	
	private static final Map<Character,Integer> LETTERS = new TreeMap<Character, Integer>();
	
	public static void main(String[] args) throws IOException {
		generateLetterMap("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		BufferedReader reader = new BufferedReader(new FileReader("names.txt"));
		String line = reader.readLine();
		reader.close();
		line = line.replaceAll("\"", "");
		String[] names = line.split(",");
		Arrays.sort(names);
		int total = 0;
		for (int index = 0; index < names.length; index++) {
			String name = names[index];
			int sum = getLetterValues(name);
			total += (index + 1) * sum;
		}
		System.out.println("Total Name Scores: " + total);
	}

	private static int getLetterValues(String name) {
		int sum = 0;
		for (int i = 0; i < name.length(); i++) {
			char letter = name.charAt(i);
			sum += LETTERS.get(letter);
		}
		return sum;
	}

	private static void generateLetterMap(String letters) {
		for (int i = 0; i < letters.length(); i++) {
			char letter = letters.charAt(i);
			LETTERS.put(letter, i+1);
		}
	}
}











