package ProjectEuler.Questions_21_through_30;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Q22_NamesScores {
	
	private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("names.txt"));
		String line = reader.readLine();
		reader.close();
		line = line.replaceAll("\"", "");
		String[] names = line.split(",");
		Arrays.sort(names);
		int total = 0;
		for (int index = 0; index < names.length; index++) {
			String name = names[index];
			int sum = 0;
			for (int i = 0; i < name.length(); i++) {
				sum += LETTERS.indexOf(name.charAt(i)) + 1;
			}
			total += ((index + 1) * (sum));
		}
	}
}
