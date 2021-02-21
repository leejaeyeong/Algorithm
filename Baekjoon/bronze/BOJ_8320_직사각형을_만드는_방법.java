package date0220;

import java.util.Scanner;

public class BOJ_8320_직사각형을_만드는_방법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j * i <= n; j++) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
