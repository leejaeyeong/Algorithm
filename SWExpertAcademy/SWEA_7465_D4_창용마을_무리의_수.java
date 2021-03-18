package date0319;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7465_D4_창용마을_무리의_수 {
	static int N, M;
	static int[] state;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			state = new int[N+1];
			for (int i = 1; i <= N; i++) {
				state[i] = i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (state[i] == i)
					cnt++;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
	static int find(int a) {
		if (state[a] == a) return a;
		return state[a] = find(state[a]);
	}
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return;
		state[aRoot] = state[bRoot];
	}
}
