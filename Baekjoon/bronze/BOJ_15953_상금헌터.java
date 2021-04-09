package date0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15953_상금헌터 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] festival2017Money = new int[7][2];
		int[][] festival2018Money = new int[6][2];
		int[] money = { 5000000, 3000000, 2000000, 500000, 300000, 100000 };
		int[] money2 = { 5120000, 2560000, 1280000, 640000, 320000 };
		for (int i = 1; i <= 6; i++) {
			festival2017Money[i][0] = festival2017Money[i-1][0] + i;  
			festival2017Money[i][1] = money[i-1];
		}
		for (int i = 1; i <= 5; i++) {
			festival2018Money[i][0] = festival2018Money[i-1][0] + (int)Math.pow(2, i-1);
			festival2018Money[i][1] = money2[i-1];
		}
		int N = stoi(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int festival2017 = stoi(st.nextToken());
			int festival2018 = stoi(st.nextToken());
			int result = 0;
			if (festival2017 != 0) {
				for (int j = 1; j <= 6; j++) {
					if (festival2017Money[j][0] >= festival2017) {
						result += festival2017Money[j][1];
						break;
					}
				}
			}
			if (festival2018 != 0) {
				for (int j = 1; j <= 5; j++) {
					if (festival2018Money[j][0] >= festival2018) {
						result += festival2018Money[j][1];
						break;
					}
				}
			}
			System.out.println(result);
		}

	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
