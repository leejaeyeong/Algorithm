package date0611;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
	static int N;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = stoi(br.readLine());
		map = new int[N][N];
		int maxHeight = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(st.nextToken());
				if (maxHeight < map[i][j]) maxHeight = map[i][j];
			}
		}
		
		int maxArea = 0;
		for (int i = 0; i < maxHeight; i++) {
			int[][] testMap = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				System.arraycopy(map[j], 0, testMap[j], 0, N);
			}
			
			int areaCount = countArea(testMap, i);
			if (maxArea < areaCount) {
				maxArea = areaCount;
			}
		}
		System.out.println(maxArea);
	}

	private static int countArea(int[][] testMap, int amount) {
		rainDrop(testMap, amount);
		int areaCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (testMap[i][j] != 0) {
					bfs(i, j, testMap);
					areaCount++;
				}
			}
		}
		return areaCount;
	}

	private static void bfs(int y, int x, int[][] testMap) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {y, x});
		testMap[y][x] = 0;
		
		while (!que.isEmpty()) {
			int yy = que.peek()[0];
			int xx = que.poll()[1];
			
			for (int i = 0; i < 4; i++) {
				int ny = yy + dy[i];
				int nx = xx + dx[i];
				
				if (ny < 0 || ny >= N || nx < 0|| nx >= N) continue;
				if (testMap[ny][nx] == 0) continue;
				testMap[ny][nx] = 0;
				que.offer(new int[] {ny, nx});
			}
		}
	}

	private static void rainDrop(int[][] testMap, int amount) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (testMap[i][j] <= amount) testMap[i][j] = 0;
			}
		}
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
