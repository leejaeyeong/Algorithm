package date0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11559_Puyo_Puyo {
	static char[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean bomb;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int count = 0;
		while(true) {
			bomb = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						bfs(i,j);
					}
				}
			}
			reduceMap();
			if (bomb) count++;
			else break;
		}
		System.out.println(count);
	}

	private static void bfs(int i, int j) {
		char puyo = map[i][j];
		boolean[][] visited = new boolean[12][6];
		Queue<int[]> que = new LinkedList<>();
		ArrayList<int[]> removeList = new ArrayList<>();
		removeList.add(new int[] {i, j});
		que.offer(new int[] {i, j});
		visited[i][j] = true;
		int count = 1;
		
		while(!que.isEmpty()) {
			int y = que.peek()[0];
			int x = que.poll()[1];
			
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				
				if (ny < 0 || ny >= 12 || nx < 0 || nx >= 6) continue;
				if (visited[ny][nx]) continue;
				if (map[ny][nx] != puyo) continue;
				
				count++;
				visited[ny][nx] = true;
				que.offer(new int[] {ny, nx});
				removeList.add(new int[] {ny, nx});
			}
		}
		if (count >= 4) {
			bomb = true;
			for (int k = 0; k < removeList.size(); k++) {
				int y = removeList.get(k)[0];
				int x = removeList.get(k)[1];
				map[y][x] = '.';
			}
		}
	}
	
	private static void reduceMap() {
		for (int i = 0; i < 6; i++) {
			reduceRow(i);
		}
	}
	private static void reduceRow(int c) {
		for (int i = 11; i > 0; i--) {
			if (map[i][c] == '.') {
				for (int j = i-1; j >= 0; j--) {
					if (map[j][c] != '.') {
						map[i][c] = map[j][c];
						map[j][c] = '.';
						break;
					}
				}
			}
		}
	}
}
