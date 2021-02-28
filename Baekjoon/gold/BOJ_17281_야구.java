package date0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {
	static int N, maxScore = Integer.MIN_VALUE;
	static boolean[] visited;
	static int[][] inning;
	static int[] selected, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inning = new int[N][9];
		visited = new boolean[9];
		selected = new int[9];
		res = new int[9];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm(0);
		System.out.println(maxScore);
	}
	private static void perm(int cnt) {
		if (cnt == 8) {
			System.arraycopy(selected, 0, res, 0, 3);
			System.arraycopy(selected, 3, res, 4, 5);
			game();
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			selected[cnt] = i;
			perm(cnt+1);
			visited[i] = false;
		}
	}
	private static void game() {
		int lastHitter = 0;
		int sumScore = 0;
		for (int i = 0; i < N; i++) { // 게임 시도
			int[] runner = new int[9];
			int out = 0;
			int subScore = 0;
			while (true) {
				int hitter = res[lastHitter % 9];
				int score = inning[i][hitter];
				if (score == 0) {
					++lastHitter;
					if (++out == 3) break;
					continue;
				}
				runner[hitter] += score;
				for (int j = 0; j < 9; j++) {
					if (runner[j] == 0) continue;
					if (hitter == j) continue;
					runner[j] += score;
				}
				for (int j = 0; j < 9; j++) {
					if (runner[j] >= 4) {
						runner[j] = 0;
						++subScore;
					}
				}
				++lastHitter;
			}
			sumScore += subScore;
		}
		maxScore = Math.max(maxScore, sumScore);
	}
}	
