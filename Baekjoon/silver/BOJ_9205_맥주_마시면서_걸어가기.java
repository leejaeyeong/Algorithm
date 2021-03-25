package date0325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9205_맥주_마시면서_걸어가기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			int N = stoi(br.readLine()) + 2; // 편의점 수 + 시작지점 + 도착지점
			int[][] map = new int[N][N];
			int[][] info = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				info[i][0] = stoi(st.nextToken());
				info[i][1] = stoi(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					map[i][j] = Math.abs(info[i][0] - info[j][0]) + Math.abs(info[i][1] - info[j][1]);
					if (map[i][j] <= 1000) // 거리가 1000 이하이면 갈 수 있음을 표시
						map[i][j] = 1;
				}
			}
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]); // 정점별 최소거리 구하기
					}
				}
			}
			System.out.println(map[0][N-1] > 1000 ? "sad" : "happy");
		}
			
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
