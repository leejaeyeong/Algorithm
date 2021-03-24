package date0324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static int[][] map;
	static int r, c, cheese, lastCheeseCnt;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = stoi(st.nextToken());
		c = stoi(st.nextToken());
		map = new int[r][c];
		cheese = 0;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = stoi(st.nextToken());
				if (map[i][j] == 1)
					cheese++;
			}
		}
		
		int time = 0;
		while(bfs()) time++;
		System.out.println(time+1);
		System.out.println(lastCheeseCnt);
	}
	static boolean bfs() {
		lastCheeseCnt = cheese;
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[r][c];
		que.offer(new int[] {0,0});
		visited[0][0] = true;
		while (!que.isEmpty()) {
			int y = que.peek()[0];
			int x = que.poll()[1];
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (visited[ny][nx]) continue;
				if (map[ny][nx] == 1) {
					map[ny][nx] = 0;
					cheese--;
				} else {
					que.offer(new int[] {ny, nx});
				}
				visited[ny][nx] = true;
			}
		}
		return cheese > 0;
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
