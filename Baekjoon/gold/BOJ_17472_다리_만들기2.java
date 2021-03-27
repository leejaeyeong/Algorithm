package date0328;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리_만들기2 {
	static class Edge {
		int from, to, weight;
		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	static int r, c, island;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]>[] vertexLoc;
	static ArrayList<Edge> edgeList;
	static ArrayList<int[]> islandList;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = stoi(st.nextToken());
		c = stoi(st.nextToken());
		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		// 섬 번호 부여하기
		islandList = new ArrayList<>();
		visited = new boolean[r][c];
		island = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
					island++;
				}
			}
		}
		
		// 크루스칼 makeset
		parents = new int[island];
		for (int i = 0; i < island; i++) {
			parents[i] = i;
		}
		
		edgeList = new ArrayList<>();
		buildEdge(); // 다리 놓아보기 
		edgeList.sort((o1,o2)-> o1.weight - o2.weight); // 다리 길이 짧은 순으로 정렬
		
		int count = 0, res = 0;
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			if (union(edge.from - 1, edge.to -1)) {
				res += edge.weight;
				if (++count == island) break;
			}
		}
		if (count != island-1) res = -1;
		System.out.println(res);
	}
	private static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	private static boolean union (int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	private static void simulation(int y, int x, int dir, int length, int from) {
		if (map[y][x] != 0) { // 다리가 놓인 경우
			if (length <= 2) return;
			edgeList.add(new Edge(from, map[y][x], length-1));
			return;
		}
		
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (ny < 0 || ny >= r || nx < 0 || nx >= c) return;
		simulation(ny, nx, dir, length+1, from);
		
	}
	private static void buildEdge() {
		for (int i = 0; i < islandList.size(); i++) {
			int y = islandList.get(i)[0];
			int x = islandList.get(i)[1];
			
			for (int j = 0; j < 4; j++) {
				int ny = y + dy[j];
				int nx = x + dx[j];
				
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (map[y][x] == map[ny][nx]) continue;
				if (map[ny][nx] == 0) {
					simulation(ny, nx, j, 1, map[y][x]);
				}
			}
		}
	}
	private static void bfs(int y, int x) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {y,x});
		visited[y][x] = true;
		int num = island + 1;
		map[y][x] = num;
		while(!que.isEmpty()) {
			int a = que.peek()[0];
			int b = que.poll()[1];
			islandList.add(new int[] {a,b});
			for (int i = 0; i < 4; i++) {
				int ny = a + dy[i];
				int nx = b + dx[i];
				
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (visited[ny][nx]) continue;
				if (map[ny][nx] != 1 || map[ny][nx] == 0) continue;
				map[ny][nx] = num;
				que.offer(new int[] {ny,nx});
				visited[ny][nx] = true;
			}
		}
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
