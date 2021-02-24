package date0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jungol_1037_오류교정 {
	static int[][] data;
	static int N, failRow;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (check()) { // 패리티이면
			System.out.println("OK");
			System.exit(0);
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					data[i][j] ^= 1;
					if (check()) {
						System.out.println("Change bit (" + ++i + "," + ++j + ")");
						System.exit(0);
					}
					data[i][j] ^= 1;
				}
			}
		}
		System.out.println("Corrupt");
	}
	static boolean check() {
		for (int i = 0; i < N; i++) {
			int rowSum = 0;
			int colSum = 0;
			for (int j = 0; j < N; j++) {
				rowSum += data[i][j];
				colSum += data[j][i];
			}
			if (rowSum % 2 == 1 || colSum % 2 == 1) {
				return false;
			}
		}
		return true;
	}
}
