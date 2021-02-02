package Algorithm0202;

import java.util.Scanner;

public class SWEA_1954_D2_달팽이숫자 {
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int num = 0;
	static int[][] arr;
	static boolean[][] visited;
	static int N;
	static boolean isInside(int y, int x) { // 범위 내에 유효한 좌표이고, 해당 좌표에 값이 없으면 true 반환
		if (y < 0 || y >= N || x < 0 || x >= N || arr[y][x] != 0 || visited[y][x]) 
			return false;
		return true;
	}
	static void fill(int y, int x, int dir) {
		visited[y][x] = true;
		arr[y][x] = ++num;
		
		if (isInside(y + dy[dir], x + dx[dir])) {
			fill(y + dy[dir], x + dx[dir], dir);
			return;
		}
		
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			
			if (!isInside(ny, nx)) {
				continue;
			}
			fill(ny, nx, k);
			break;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			visited = new boolean[N][N];
			fill(0, 0, 0);
			num = 0;
			
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
