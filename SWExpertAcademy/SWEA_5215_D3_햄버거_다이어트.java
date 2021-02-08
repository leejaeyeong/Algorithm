package date0208;

import java.util.Scanner;

public class SWEA_5215_D3_햄버거_다이어트 {
	static boolean[] isSelected;
	static int[][] arr;
	static int L;
	static int N;
	static int bestScore;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			bestScore = 0;
			L = sc.nextInt();
			arr = new int[N][2];
			isSelected = new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			subset(0);
			System.out.println("#" + t + " " + bestScore);
		}
	}
	static void subset(int cnt) {
		if (cnt == N) {
			int calorie = 0; // 칼로리 합
			int score = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					calorie += arr[i][1];
					score += arr[i][0];
				}
				if (calorie > L) {
					return;
				}
			}
			bestScore = Math.max(bestScore, score);
			return;
		}
		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);
		
	}
}
