package date0226;

import java.util.Scanner;

public class BOJ_2669_직사각형_합집합의_면적 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[101][101];
		for (int i = 0; i < 4; i++) {
			int xs = sc.nextInt();
			int ys = sc.nextInt();
			int xe = sc.nextInt();
			int ye = sc.nextInt();
			for (int j = ys; j < ye; j++) {
				for (int k = xs; k < xe; k++) {
					arr[j][k] = 1;
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (arr[i][j] == 1) cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
