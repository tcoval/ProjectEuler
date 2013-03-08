package ProjectEuler.Questions_11_through_20;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/*
 * Question #15
 * 
 * Startin in the left corner of a 2x2 grid, and only being 
 * able to move to the right and down, there are exactly 6 
 * routes to the bottom right corner.
 * 
 * Question: How many such routes are there through a 20x20 grid?
 * Answer: 137846528820
 */

public class Q15_LatticePaths {

	private static Map<Point,Long> values;
	private static final int SIZE = 20;
	
	public static void main(String[] args) {
		values = new HashMap<Point,Long>();
		Point startingPoint = new Point(0,0);
		System.out.println(calcPathNum(startingPoint));
	}
	
	private static long calcPathNum(Point point) {
		if (values.containsKey(point)) {
			return values.get(point);
		} else if (point.x == SIZE || point.y == SIZE) {
			values.put(point, 1L);
			return 1;
		} else {
			long value = calcPathNum(new Point(point.x + 1, point.y)) + 
					calcPathNum(new Point(point.x, point.y + 1));
			values.put(point, value);
			return value;
		}
	}
}
