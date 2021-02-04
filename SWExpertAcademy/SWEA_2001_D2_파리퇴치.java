package date0203;

import java.util.Scanner;

public class SWEA_2001_D2_ÆÄ¸®ÅðÄ¡ {
	static int[][] arr;
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					int sum = 0;
					for (int k = i; k < i + M; k++) {
						for (int l = j; l < j + M; l++) {
							sum += arr[k][l];
						}
					}
					max = Math.max(max, sum);
				}
			}
			
			System.out.println("#" + t + " " + max);
			max = 0;
		}
	}
}
