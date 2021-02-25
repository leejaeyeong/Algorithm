package date0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7236_D3_저수지의_물의_총깊이_구하기 {
	static int[] dy = {1,-1, 0, 0, -1, -1, 1, 1};
	static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int max = 0;
			char[][] arr = new char[N+2][N+2];
			StringTokenizer st;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					arr[i][j] = st.nextToken().charAt(0);
				}
			}
			for (int i = 0; i < N + 2; i++) { // 패딩 채우기
				arr[0][i] = arr[N+1][i] = arr[i][0] = arr[i][N+1] = 'G';
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (arr[i][j] != 'W') continue;
					int sum = 0;
					for (int k = 0; k < 8; k++) {
						if (arr[i+dy[k]][j+dx[k]] == 'W') {
							sum++;
						} 
						if (sum == 0) max = Math.max(max, 1);
					}
					max = Math.max(max, sum);
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}
