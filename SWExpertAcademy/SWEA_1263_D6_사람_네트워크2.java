package date0325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1263_D6_사람_네트워크2 {
	static final int INF = (int)1e9;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = stoi(st.nextToken());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = stoi(st.nextToken());
					if (i != j && arr[i][j] == 0) {
						arr[i][j] = INF;
					}
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
					}
				}
			}
			
			int res = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += arr[i][j];
                }
                res = Math.min(res, sum);
            }
            System.out.printf("#%d %d\n", t, res);

		}

	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
