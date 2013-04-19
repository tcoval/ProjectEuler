package ProjectEuler.Questions_341_through_350;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Question #345
 * 
 * We define the matrix sum as the maximum sum of matrix elements 
 * with each element being the only one in his row and column. 
 * For example, the matrix sum of the matrix below equals 3315 
 * ( 863 + 383 + 343 + 959 + 767 = 3315):
 * 
 *   7  53 183 439 863
 * 497 383 563  79 973
 * 287  63 343 169 583
 * 627 343 773 959 943
 * 767 473 103 699 303
 * 
 * ===========================================================
 * 
 *  7  53 183 439 863 497 383 563  79 973 287  63 343 169 583
 * 627 343 773 959 943 767 473 103 699 303 957 703 583 639 913
 * 447 283 463  29  23 487 463 993 119 883 327 493 423 159 743
 * 217 623   3 399 853 407 103 983  89 463 290 516 212 462 350
 * 960 376 682 962 300 780 486 502 912 800 250 346 172 812 350
 * 870 456 192 162 593 473 915  45 989 873 823 965 425 329 803
 * 973 965 905 919 133 673 665 235 509 613 673 815 165 992 326
 * 322 148 972 962 286 255 941 541 265 323 925 281 601  95 973
 * 445 721  11 525 473  65 511 164 138 672  18 428 154 448 848
 * 414 456 310 312 798 104 566 520 302 248 694 976 430 392 198
 * 184 829 373 181 631 101 969 613 840 740 778 458 284 760 390
 * 821 461 843 513  17 901 711 993 293 157 274  94 192 156 574
 *  34 124   4 878 450 476 712 914 838 669 875 299 823 329 699
 * 815 559 813 459 522 788 168 586 966 232 308 833 251 631 107
 * 813 883 451 509 615  77 281 613 459 205 380 274 302  35 805
 * 
 * Question: Find the matrix sum of the given matrix above.
 * Answer: 13938
 */

public class Q345_MatrixSum {

	public static final int SIZE = 15;
	public static final int[][] MATRIX = new int[SIZE][SIZE];

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("matrix"));
		createMatrix(input);
		int sum = solveMatrix();
		System.out.println("Sum: " + sum);
	}

	private static int solveMatrix() {
		int[] x = new int[SIZE];
		int[] y = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			x[i] = i;
			y[i] = i;
		}
		boolean moved;
		do {
			moved = trySwapX(false, x, y);
			moved = trySwapY(moved, x, y);
		} while (moved);
		int sum = 0;
		for (int i = 0; i < SIZE; i++) {
			sum += MATRIX[x[i]][y[i]];
		}
		return sum;
	}

	private static boolean trySwapX(boolean moved, int[] x, int[] y) {
		for (int point1 = 0; point1 < SIZE; point1++) {
			for (int point2 = 0; point2 < SIZE; point2++) {
				int sum1 = MATRIX[x[point1]][y[point1]]
						+ MATRIX[x[point2]][y[point2]];
				int sum2 = MATRIX[x[point2]][y[point1]]
						+ MATRIX[x[point1]][y[point2]];
				if (sum2 > sum1) {
					int temp = x[point1];
					x[point1] = x[point2];
					x[point2] = temp;
					moved = true;
					break;
				}
			}
			if (moved) {
				break;
			}
		}
		return moved;
	}

	private static boolean trySwapY(boolean moved, int[] x, int[] y) {
		for (int point1 = 0; point1 < SIZE; point1++) {
			for (int point2 = 0; point2 < SIZE; point2++) {
				int sum1 = MATRIX[x[point1]][y[point1]]
						+ MATRIX[x[point2]][y[point2]];
				int sum2 = MATRIX[x[point1]][y[point2]]
						+ MATRIX[x[point2]][y[point1]];
				if (sum2 > sum1) {
					int temp = y[point1];
					y[point1] = y[point2];
					y[point2] = temp;
					moved = true;
					break;
				}
			}
			if (moved) {
				break;
			}
		}
		return moved;
	}

	private static void createMatrix(Scanner input) {
		for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {
				MATRIX[row][column] = input.nextInt();
			}
		}
	}
}
