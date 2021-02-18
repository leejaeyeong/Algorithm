package date0218;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1987_알파벳 {
	static char[][] arr;
	static ArrayList<Character> bag;
	static int r, c, maxMove;
	static int dy[] = {1, -1, 0, 0}, dx[] = {0, 0, -1, 1};
	
	static void solve(int y, int x, int moveCnt) {
		if (maxMove < moveCnt) {
			maxMove = moveCnt;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny < 0 || ny >= r || nx < 0 || nx >= c) 
				continue;
			
			if (!bag.contains(arr[ny][nx])) {
				bag.add(arr[ny][nx]);
				solve(ny,nx,moveCnt+1);
				bag.remove(bag.indexOf(arr[ny][nx]));
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		arr = new char[r][c];
		bag = new ArrayList<>();
		maxMove = 0;
		for (int i = 0; i < r; i++) {
			arr[i] = sc.next().toCharArray();
		}
		bag.add(arr[0][0]);
		solve(0,0,1);
		System.out.println(maxMove);
	}
}
