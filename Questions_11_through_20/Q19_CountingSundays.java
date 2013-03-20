package ProjectEuler.Questions_11_through_20;

/*
 * Question #19
 * 
 * Information Given:
 * 
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * 
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * 
 * Question: How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 * Answer: 171
 */

public class Q19_CountingSundays {

	private static final int[] THIRTY_ONE = {4, 6, 9, 11};
	private static final String[] days = {"Mon","Tue","Wed","Thur","Fri","Sat","Sun"};
	
	public static void main(String[] args) {
		int dayOfTheWeek = 1;
		int count = 0;
		for (int year = 1901; year <= 2000; year++) {
			for (int month = 1; month <= 12; month++) {
				int maxDays = 31;
				if (month == 4 || month == 6 || month == 9 || month == 11) {
					maxDays = 30;
				} else if (month == 2) {
					maxDays = 28;
					if ((year % 4 == 0 && year % 100 != 0) || year/100 % 4 == 0) {
						maxDays++;
					}
				}
				for (int day = 1; day <= maxDays; day++) {
					dayOfTheWeek++;
					if (dayOfTheWeek > 7) {
						dayOfTheWeek = 1;
					}
					if (dayOfTheWeek == 7 && day == 1) {
						count++;
					}
				}
			}
		}
		System.out.println("Number of Sundays on the 1st: " + count);
	}
}
