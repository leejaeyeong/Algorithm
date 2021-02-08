package date0207;

import java.util.Scanner;

public class SWEA_1974_D2_스도쿠_검증 {
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		for (int t = 1; t <= 10; t++ ) {
			arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			boolean squareFail = false;
			for (int i = 0; i < 9; i += 3 ) {
				for (int j = 0; j < 9; j += 3) {
					if (!squareCheck(i,j)) {
						squareFail = true;
						break;
					}
				}
				if (squareFail)
					break;
			}
			if (squareFail || !verticalCheck() || !horizentalCheck()) {
				System.out.println("#" + t + " " + 0);
				continue;
			}
			System.out.println("#" + t + " " + 1);
			
			
		}
	}
	static boolean horizentalCheck() {
		for (int i = 0; i < 9; i++) {
			boolean[] numberCheck = new boolean[10];
			for (int j = 0; j < 9; j++) {
				numberCheck[arr[j][i]] = true;
			}
			for (int j = 1; j < 10; j++) {
				if (!numberCheck[j])
					return false;
			}
		}
		return true;
	}
	static boolean verticalCheck() {
		for (int i = 0; i < 9; i++) {
			boolean[] numberCheck = new boolean[10];
			for (int j = 0; j < 9; j++) {
				numberCheck[arr[i][j]] = true;
			}
			for (int j = 1; j < 10; j++) {
				if (!numberCheck[j])
					return false;
			}
		}
		return true;
	}
	static boolean squareCheck(int y, int x) {
		boolean[] numberCheck = new boolean[10];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				numberCheck[arr[y+i][x+j]] = true;
			}
		}
		for (int i = 1; i < 10; i++) {
			if (!numberCheck[i])
				return false;
		}
		return true;
	}
}
