package date0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SWEA_1249_D4_보급로 {
	static int N;
	static int[][] map, costMap;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	static int minCost;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = stoi(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			System.out.println("#" + t + " " + bfs());
		}
	}
	private static int bfs() {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		que.offer(new int[] {0, 0, 0});
		visited[0][0] = true;
		
		while (!que.isEmpty()) {
			int y = que.peek()[0];
			int x = que.peek()[1];
			int cost = que.poll()[2];
			
			if (y == N-1 && x == N-1) {
				return cost;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				if (visited[ny][nx]) continue;
				
				que.offer(new int[] {ny, nx, cost + map[ny][nx]});
				visited[ny][nx] = true;
			}
		}
		
		return -1;
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
