package date0221;

import java.util.Scanner;

public class BOJ_10163_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] count = new int[N+1];
		int[][] arr = new int[101][101];
		for (int i = 1; i <= N; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			for (int j = y; j < y + r; j++) {
				for (int k = x; k < x + c; k++) {
					arr[j][k] = i;
				}
			}
		}
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (arr[i][j] == 0) continue;
				++count[arr[i][j]];
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(count[i+1]);
		}
	}
}
