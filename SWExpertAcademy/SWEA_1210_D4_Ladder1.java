//package Algorithm0202;
//
//import java.util.Scanner;
//
//public class Ladder1 {
//	static int[][] map;
//	static boolean[][] visit;
//	static int res = 0;
//	static int fin[] = new int[2];
//	static int dx[] = {0, 0};
//	static int dy[] = {-1, 1};
//	static int dir[];
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		for (int tc = 0; tc < 10; tc++) {
//			int TC = sc.nextInt();
//			map = new int[100][100];
//			visit = new boolean[100][100];
//			
//			for (int i = 0; i < 100; i++) {
//				for (int j = 0; j < 100; j++) {
//					map[i][j] = sc.nextInt();
//					if (map[i][j] == 2) {
//						fin = new int[] {i, j};
//					}
//				}
//			}
//			System.out.println(fin[1]);
//			//dfs(99, fin[1]);
//			//System.out.println("#" + TC + " " + res);
//		}
//	}
//	
//	public static void dfs(int x, int y) {
//		if (x == 0) {
//			res = y;
//			return;
//		}
//		
//		visit[x][y] = true;
//		dir = new int[] {-1, 0};
//		
//		for (int i = 0; i < dx.length; i++) {
//			int nx = x + dx[i];
//			int ny = y + dy[i];
//			
//			if (nx >= 100 | nx < 0 || ny >= 100 || ny < 0) 
//				continue;
//			if (map[nx][ny] == 0)
//				continue;
//			if (visit[nx][ny])
//				continue;
//			
//			dir = new int[] {dx[i], dy[i]};
//			
//		}
//		dfs(x+dir[0], y+dir[1]);
//	}
//}


package Algorithm0202;

import java.util.Scanner;

public class SWEA_1210_D4_Ladder1 {
	static boolean[][] visited;
	static int[][] arr;
	static int[] dy = {0, 0, -1};
	static int[] dx = {-1, 1, 0};
	static int test = 0;
	static void search(int r, int c) {
		if (r == 0) {
			test = c;
			return;
		}
		visited[r][c] = true;
		for (int i = 0; i < 3; i++) {
			int y = r + dy[i];
			int x = c + dx[i];
			
			if (y < 0 || y >= 100 || x < 0 || x >= 100 || visited[y][x] || arr[y][x] == 0) 
				continue;
			
			search(y, x);
			break;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			visited = new boolean[100][100];
			arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < 100; i++) {
				if (arr[99][i] == 2) {
					search(99,i);
					System.out.println("#" + tc + " " + test);
					break;
				}
			}
		}
	}
}
