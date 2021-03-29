package date0329;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667_단지번호붙이기 {
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
	static boolean[][] visited; 
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		visited = new boolean[n][n];
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0 || visited[i][j]) continue;
				visited[i][j] = true;
				list.add(dfs(i,j,n));
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for (int res : list)
			System.out.println(res);
			
	}
	private static int dfs(int y, int x, int n) {
		int res = 1;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
			if (map[ny][nx] == 0) continue;
			if (visited[ny][nx]) continue;
			visited[ny][nx] = true;
			res += dfs(ny,nx,n);
		}
		return res;
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
