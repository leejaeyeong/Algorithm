package date0328;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int r, c, emptyArea, answer = Integer.MIN_VALUE;
	static int[][] map, selectArea;
	static ArrayList<int[]> emptyList, virusList;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = stoi(st.nextToken());
		c = stoi(st.nextToken());
		map = new int[r][c];
		emptyList = new ArrayList<>();
		virusList = new ArrayList<>();
		selectArea = new int[3][2];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = stoi(st.nextToken());
				if (map[i][j] == 0) {
					emptyList.add(new int[] {i, j});
					emptyArea++;
				} else if (map[i][j] == 2) {
					virusList.add(new int[] {i, j});
				}
			}
		}
		comb(0,0);
		// 안전 영역 크기의 최댓값 출력
		System.out.println(answer);
	}
	private static void bfs(int[][] testMap, int emptyArea) {
		Queue<int[]> que = new LinkedList<>();
		visited = new boolean[r][c];
		for (int i = 0; i < virusList.size(); i++) {
			int[] loc = virusList.get(i);
			que.offer(new int[] {loc[0], loc[1]}); // 바이러스 좌표 큐에 넣기
			visited[loc[0]][loc[1]] = true;
		}
		while(!que.isEmpty()) {
			int y = que.peek()[0];
			int x = que.poll()[1];
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (testMap[ny][nx] == 1 || testMap[ny][nx] == 2) continue;
				if (visited[ny][nx]) continue;
				emptyArea--;
				que.offer(new int[] {ny, nx});
				visited[ny][nx] = true;
			}
		}
		answer = Math.max(answer, emptyArea);
		
	}
	private static void comb(int cnt, int index) {
		if (cnt == 3) {
			int[][] testMap = new int[r][c];
			copyMap(map,testMap);
			for (int i = 0; i < 3; i++) { // 벽 세우기
				testMap[selectArea[i][0]][selectArea[i][1]] = 1;
			}
			bfs(testMap, emptyArea-3);
			return;
		}
		for (int i = index; i < emptyList.size(); i++) {
			int[] loc = emptyList.get(i);
			selectArea[cnt][0] = loc[0];
			selectArea[cnt][1] = loc[1];
			comb(cnt+1, i+1);
		}
	}
	private static void copyMap(int[][] src, int[][] temp) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp[i][j] = src[i][j];
			}
		}
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
