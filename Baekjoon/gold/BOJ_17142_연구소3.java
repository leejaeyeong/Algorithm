package date0320;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142_연구소3 {
	static int N, M, totalMinSecond, staticEmptySpace;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]> virusList;
	static int[][] selectedVirus;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		selectedVirus = new int[M][2];
		virusList = new ArrayList<>();
		totalMinSecond = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(st.nextToken());
				if (map[i][j] == 2) { // 바이러스가 있는 위치 저장
					virusList.add(new int[] { i, j });
				} else if (map[i][j] == 0) {
					staticEmptySpace++;
				}
			}
		}
		if (staticEmptySpace == 0) { // 감염시킬 공간이 없으면
			System.out.println(0);
			return;
		}
		combi(0, 0);
		if (totalMinSecond == Integer.MAX_VALUE)
			totalMinSecond = -1;
		System.out.println(totalMinSecond);
	}

	private static void combi(int cnt, int index) {
		if (cnt == M) {
			int[][] testMap = new int[N][N];
			copyMap(map, testMap);
			bfs(testMap);
			visited = new boolean[N][N]; // 방문체크 초기화
			return;
		}
		for (int i = index; i < virusList.size(); i++) {
			int[] virus = virusList.get(i);
			selectedVirus[cnt][0] = virus[0]; // 바이러스 y 좌표
			selectedVirus[cnt][1] = virus[1]; // 바이러스 x 좌표
			combi(cnt + 1, i + 1);
		}
	}

	private static void bfs(int[][] testMap) {
		Queue<int[]> que = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			// 시간, y좌표, x좌표
			int y = selectedVirus[i][0];
			int x = selectedVirus[i][1];
			que.offer(new int[] { 0, y, x, 0 });
			visited[y][x] = true;
		}
		int emptySpace = staticEmptySpace;
		int localMaxSecond = 0;
		while (!que.isEmpty()) {
			int second = que.peek()[0];
			int y = que.peek()[1];
			int x = que.poll()[2];

			if (localMaxSecond < second)
				localMaxSecond = second;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny < 0 || ny >= N || nx < 0 || nx >= N)
					continue;
				if (visited[ny][nx])
					continue;
				if (testMap[ny][nx] == 1) // 벽
					continue;

				if (testMap[ny][nx] == 0)
					emptySpace--;
				
				if (emptySpace == 0) {
					totalMinSecond = Math.min(totalMinSecond, localMaxSecond+1);
					return;
				}
				visited[ny][nx] = true;
				que.offer(new int[] { second+1 , ny, nx, 0 });
			}
		}
	}

	private static void copyMap(int[][] src, int[][] temp) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = src[i][j];
			}
		}
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
