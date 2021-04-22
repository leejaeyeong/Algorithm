package date0422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1868_파핑파핑_지뢰찾기 {
	static int N, click;
	static char[][] map;
	static int[] dy = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			click = 0;
			N = stoi(br.readLine());
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = ch[j];
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.' && check(i,j)) {
						bfs(i,j);
						click++;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') click++;
				}
			}
			System.out.println("#" + t + " " + click);
		}
	}
	
	private static void bfs(int r, int c) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {r, c});
		map[r][c] = 'x';
		while (!que.isEmpty()) {
			int y = que.peek()[0];
			int x = que.poll()[1];
			
			for (int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				if (map[ny][nx] == '*') continue; 
				if (map[ny][nx] == 'x') continue;
				if (check(ny,nx)) {
					que.offer(new int[] {ny, nx});
				}
				map[ny][nx] = 'x';
				
			}
		}
	}
	// 연속해서 터트릴 수 있는지 체크
	private static boolean check(int r, int c) {
		for (int i = 0; i < 8; i++) {
			int ny = r + dy[i];
			int nx = c + dx[i];
			if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
			if (map[ny][nx] == '*') return false;
		}
		
		return true;
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
