package date0324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈_원숭이 {
	static class Monkey {
		int y, x, k, actionCnt;
		Monkey(int y, int x, int k, int actionCnt) {
			this.y = y;
			this.x = x;
			this.k = k;
			this.actionCnt = actionCnt;
		}
	}
	static int k, r, c;
	static int minAction = Integer.MAX_VALUE;
	static int[][] map;
	static int[] dy4 = { -1, 1, 0, 0 };
	static int[] dx4 = { 0, 0, -1, 1 };
	static int[] dy8 = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dx8 = { -1,  1,  2, 2, 1,-1,-2, -2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = stoi(st.nextToken());
		r = stoi(st.nextToken());
		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		bfs();
		if (minAction == Integer.MAX_VALUE) minAction = -1;
		System.out.println(minAction);
	}

	private static void bfs() {
		Queue<Monkey> que = new LinkedList<>();
		boolean visited[][][] = new boolean[r][c][k+1];
		que.offer(new Monkey(0, 0, k, 0));
		visited[0][0][k] = true; 
		while (!que.isEmpty()) {
			Monkey monkey = que.poll();
			if (monkey.y == r-1 && monkey.x == c-1) {
				minAction = Math.min(minAction, monkey.actionCnt);
				return;
			}
			
			if (monkey.k > 0) { // 말 처럼 움직일 수 있으면 말처럼 가보기
				for (int i = 0; i < 8; i++) {
					int ny = monkey.y + dy8[i];
					int nx = monkey.x + dx8[i];
					int currK = monkey.k;

					if (ny < 0 || ny >= r || nx < 0 || nx >= c)continue;
					if (visited[ny][nx][currK-1]) continue;
					if (map[ny][nx] == 1) continue;
					Monkey newMonkey = new Monkey(ny, nx, currK-1, monkey.actionCnt + 1);
					que.offer(newMonkey);
					visited[ny][nx][currK-1] = true;
				}
			}
			// 현재 위치에서 원숭이처럼 가보기
			for (int i = 0; i < 4; i++) {
				int ny = monkey.y + dy4[i];
				int nx = monkey.x + dx4[i];
				int currK = monkey.k;
				
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (visited[ny][nx][currK]) continue;
				if (map[ny][nx] == 1) continue;
				Monkey newMonkey = new Monkey(ny, nx, currK, monkey.actionCnt + 1);
				que.offer(newMonkey);
				visited[ny][nx][currK] = true;
			}
		}
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
