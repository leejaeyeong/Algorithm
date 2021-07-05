package date0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1389_케빈베이컨의_6단계_법칙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int INF = 1000;
		int[][] dist = new int[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = stoi(st.nextToken());
			int to = stoi(st.nextToken());
			dist[from][to] = dist[to][from] = 1;
		}
		
		// 상태 정보 처리
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dist[i][j] != 0 || i == j) continue;
				dist[i][j] = INF;
			}
		}
		
		// 최단 거리 갱신
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int num = 0, prevMin = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += dist[i][j];
			}
			if (prevMin > sum) { // 케빈베이컨 유저, 값 갱신
				prevMin = sum;
				num = i;
			}
		}
		System.out.println(num);
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
