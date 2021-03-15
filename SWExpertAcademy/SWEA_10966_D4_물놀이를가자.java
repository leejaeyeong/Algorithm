package date0315;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 물놀이를가자 {
	static int N, M;
	static char[][] map;
	static int[][] visited;
	static Queue<int[]> que;
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			visited = new int[N][M];
			que = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'W') {
						que.offer(new int[] {i, j});
					}
				}
			}
			bfs();
			int ret = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'L')
						ret += visited[i][j];
				}
			}
			System.out.println("#" + t + " " + ret);
		}
	}
	static void bfs() {
		while (!que.isEmpty()) {
			int y = que.peek()[0];
			int x = que.poll()[1];
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue;
				if (visited[ny][nx] != 0) // 이미 값이 있는데 또 방문하면 최소가 아님
					continue;
				visited[ny][nx] = visited[y][x] + 1;
				que.offer(new int[] {ny, nx});
			}
		}
	}
}
