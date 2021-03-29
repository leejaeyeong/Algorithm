package date0329;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4991_로봇_청소기 {
	static ArrayList<int[]> dirtyList;
	static int r, c, answer, startY, startX, dirtyCnt;
	static boolean[] isSelected;
	static int[][] dist;
	static char[][] map;   
	static int[] select, dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			c = stoi(st.nextToken());
			r = stoi(st.nextToken());
			answer = Integer.MAX_VALUE;
			if (r == 0 && c == 0) 
				return;
			map = new char[r][c];
			dirtyList = new ArrayList<>();
			int num = 0;
			for (int i = 0; i < r; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < c; j++) {
					if (map[i][j] == 'o') { // 시작점
						startY = i;
						startX = j;
					} else if (map[i][j] == '*') { // 청소해야할 구역
						dirtyList.add(new int[] {i,j,num++});
					}
				}
			}
			dirtyCnt = dirtyList.size();
			dist = new int[dirtyCnt+1][dirtyCnt+1]; 
			
			// 시작점과 청소해야할 구역 각 사이의 거리 저장
			for (int i = 0; i < dirtyCnt; i++) {
				int[] loc = dirtyList.get(i);
				dist[0][i+1] = bfs(startY, startX, loc[0],loc[1]);
				dist[i+1][0] = bfs(loc[0],loc[1],startY, startX);
			}
			for (int i = 0; i < dirtyCnt-1; i++) {
				for (int j = i+1; j < dirtyCnt; j++) {
					if (i == j) {
						dist[i+1][j+1] = 0;
						continue;
					}
					// 각 청소 구역 사이의 거리 계산
					int[] loc = dirtyList.get(i);
					int[] loc2 = dirtyList.get(j);
					dist[i+1][j+1] = bfs(loc[0],loc[1],loc2[0],loc2[1]);
					dist[j+1][i+1] = bfs(loc2[0],loc2[1],loc[0],loc[1]);
				}
			}
			
			isSelected = new boolean[dirtyCnt];
			select = new int[dirtyCnt];
			perm(0);
			System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		}
	}
	
	private static void perm(int cnt) {
		if (cnt == dirtyCnt) {
			int res = 0; // 거리 
			int prev = 0; // 이전에 청소했던 구역 인덱스 
			for (int i = 0; i < cnt; i++) {
				if (dist[prev][select[i]] == -1) return;
				res += dist[prev][select[i]]; // 이동거리  증가
				prev = select[i]; // 현 위치 인덱스 갱신
			}
			if (res < answer) 
				answer = res;
			return;
		}
		for (int i = 0; i < dirtyCnt; i++) {
			if (isSelected[i]) continue;
			select[cnt] = i + 1;
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	private static int bfs(int startY, int startX, int goalY, int goalX) {
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[r][c];
		que.offer(new int [] {startY, startX, 0});
		visited[startY][startX] = true;
		while(!que.isEmpty()) {
			int y = que.peek()[0];
			int x = que.peek()[1];
			int cnt = que.poll()[2];
			if (y == goalY && x == goalX) {
				return cnt;
			}
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (map[ny][nx] == 'x') continue;
				if (visited[ny][nx]) continue;
				
				que.offer(new int[] {ny, nx, cnt+1});
				visited[ny][nx] = true;
			}
		}
		return -1;
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
