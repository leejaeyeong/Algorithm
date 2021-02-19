package date0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1733_오목 {
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		arr = new int[19][19];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 받기
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 검은색 1, 흰색 2
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				int color = arr[i][j];
				if (color == 0) continue;
				if (upRight(i,j,color) || right(i,j,color) || downRight(i,j,color) || down(i,j,color)) {
					System.out.println(color);
					System.out.println(++i + " " + ++j);
					return;
				}
				
			}
		}
		System.out.println(0);
	}
	static boolean isPossible(int y, int x) {
		if (y < 0 || y >= 19 || x < 0 || x >= 19) 
			return false;
		return true;
	}
	static boolean upRight(int y, int x, int color) {
		if (isPossible(y+1,x-1) && arr[y+1][x-1] == color) {
			return false;
		}
		int cnt = 1;
		for (int i = 0; i < 5; i++) {
			if (isPossible(--y,++x)) {
				if (arr[y][x] == color) {
					cnt++;
				}else if (i < 4) {
					return false;
				}
			}
		}
		if (cnt == 5) 
			return true;
		return false;
	}
	static boolean right(int y, int x, int color) {
		if (isPossible(y,x-1) && arr[y][x-1] == color) {
			return false;
		}
		int cnt = 1;
		for (int i = 0; i < 5; i++) {
			if (isPossible(y,++x)) {
				if (arr[y][x] == color) {
					cnt++;
				}
				else if (i < 4) {
					return false;
				}
			}
		}
		
		if (cnt == 5) 
			return true;
		return false;
	}
	static boolean downRight(int y, int x, int color) {
		if (isPossible(y-1,x-1) && (arr[y-1][x-1] == color)) {
			return false;
		}
		int cnt = 1;
		for (int i = 0; i < 5; i++) {
			if (isPossible(++y,++x)) {
				if (arr[y][x] == color) {
					cnt++;
				}else if (i < 4) {
					return false;
				}
			}
		}
		
		if (cnt == 5) 
			return true;
		return false;
	}
	static boolean down(int y, int x, int color) {
		if (isPossible(y-1,x) && (arr[y-1][x] == color)) { 
			return false;
		}
		int cnt = 1;
		for (int i = 0; i < 5; i++) {
			if (isPossible(++y,x)) {
				if (arr[y][x] == color) {
					cnt++;
				}else if (i < 4) {
					return false;
				}
			}
		}
		if (cnt == 5) 
			return true;
		return false;
	}
}
