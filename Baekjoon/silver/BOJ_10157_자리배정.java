package date0226;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10157_자리배정 {
	static int cnt, k, r, c;
	static int[] dy = {1, 0, -1, 0}, dx = {0, 1, 0 , -1};
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		r = sc.nextInt();
		k = sc.nextInt();
		if (k > r * c) {
			System.out.println(0);
			return;
		}
		visited = new boolean[r][c];
		visited[0][0] = true;
		cnt++;
		solve(0,0,0);
	}
	private static void solve(int y, int x, int dr) {
		if (cnt == k) {
			k = 0;
			System.out.println(++x + " " + ++y);
			return;
		}
		int nr = y + dy[dr];
		int nc = x + dx[dr];
		if (nr >= 0 && nr < r && nc >= 0 && nc < c && !visited[nr][nc]) {
			cnt++;
			visited[nr][nc] = true;
			solve(nr,nc,dr);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
			if (visited[ny][nx]) continue;
			
			cnt++;
			visited[ny][nx] = true;
			solve(ny,nx,i);
			return;
		}
	}
}
