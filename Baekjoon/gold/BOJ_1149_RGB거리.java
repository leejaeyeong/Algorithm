package date0323;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = stoi(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}
		int[][] dp = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = Math.min(dp[i-1][(j+1) % 3],dp[i-1][(j+2) % 3]) + arr[i-1][j];
			}
		}
		Arrays.sort(dp[N]);
		System.out.println(dp[N][0]);
	}	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
