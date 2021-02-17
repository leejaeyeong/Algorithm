package date0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	static StringBuilder sb;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		sb = new StringBuilder();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
				sum += arr[i][j];
			}
		}
		if (sum == 0 || sum == N * N) {  // 초기상태가 압축 가능한지 체크
			sb.append(sum == 0 ? "0" : "1");
		}
		else {
			sb.append("(");
			search(0,0,N);
			sb.append(")");
		}
		System.out.println(sb);
	}
	static void search(int y, int x, int N) {
		for (int n = 0; n < 4; n++) { // 4방향
			int color = arr[y][x];
			boolean fail = false;
			for (int i = y; i < y + N / 2; i++) {
				for (int j = x; j < x + N / 2; j++) {
					if (arr[i][j] != color) {
						fail = true;
						break;
					}
				}
				if (fail) break;
			}
			
			if (!fail) // 압축가능하면 
				sb.append(Integer.toString(color));
			else {
				sb.append("(");
				search(y, x, N / 2); 
				sb.append(")");
			}
			
			if (n % 2 == 0) {
				x += N / 2;
			} else {
				y += N / 2;
				x -= N / 2;
			}
		}
	}
}
