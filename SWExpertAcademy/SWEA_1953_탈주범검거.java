package date0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {
	static int r, c, startR, startC, time;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static Map<Integer, int[]> pipeMap;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		pipeMap = new HashMap<>();
		pipeMap.put(1, new int[] {0, 1, 2, 3}); // 상하좌우
		pipeMap.put(2, new int[] {0, 1}); // 상 하
		pipeMap.put(3, new int[] {2, 3}); // 좌 우
		pipeMap.put(4, new int[] {0, 3}); // 상 우
		pipeMap.put(5, new int[] {1, 3}); // 하 우
		pipeMap.put(6, new int[] {1, 2}); // 하 좌
		pipeMap.put(7, new int[] {0, 2}); // 상 좌
		
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			r = stoi(st.nextToken());
			c = stoi(st.nextToken());
			startR = stoi(st.nextToken());
			startC = stoi(st.nextToken());
			time = stoi(st.nextToken());
			map = new int[r][c];
			
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					map[i][j] = stoi(st.nextToken());
				}
			}
			System.out.println("#" + t + " " + bfs());
		}

	}

	private static int bfs() {
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[r][c];
		que.offer(new int[] {startR, startC});
		visited[startR][startC] = true;
		int spendTime = 1;
		int possibleCount = 1;
		
		while (!que.isEmpty()) {
			if (spendTime++ == time) {
				return possibleCount;
			}
			
			int size = que.size();
			
			for (int k = 0; k < size; k++) {
				int y = que.peek()[0];
				int x = que.poll()[1];
				int pipeType = map[y][x];
				
				int[] move = pipeMap.get(pipeType); // 현재 파이프에서 이동 할 수 있는 방향
				for (int i : move) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					
					if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
					if (visited[ny][nx]) continue;
					if (map[ny][nx] == 0) continue;
					
					
					if (isMove(map[ny][nx], pipeType, i)) { // 현재 파이프와 연견결될 수 있는 지 확인
						visited[ny][nx] = true;
						que.offer(new int[] {ny, nx});
						possibleCount++;
					}
				}
			}
		}
		return possibleCount;
	}
	private static boolean isMove(int pipeType, int prevPipeType, int prevProcessDir) {
		if (prevPipeType == -1 && prevProcessDir == -1) 
			return true;
		
		int target = -1;
		switch(prevProcessDir) { // 이전 파이프의 진행 방향
		case 0: target = 1; break;
		case 1: target = 0; break;
		case 2: target = 3; break;
		case 3: target = 2; break;
		}
		for (int i : pipeMap.get(pipeType)) {
			if (i == target) { // 현재 파이프가 이전 파이프의 진행 방향과 맞물리는  파이프를 가지고 있으면 
				return true;
			}
		}
		return false;
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
