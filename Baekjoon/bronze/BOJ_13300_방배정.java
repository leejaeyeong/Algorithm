package date0207;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt(); // 한 방에 배정가능한 최대
		
		int[][] info = new int[7][2];
		for (int i = 0; i < N; i++) {
			int gender = sc.nextInt();
			int year = sc.nextInt();
			info[year][gender]++;
		}
		int answer = 0;
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				answer += info[i][j] / K;
				if (info[i][j] % K != 0)
					answer += 1;
			}
		}
		System.out.println(answer);
	}
}
