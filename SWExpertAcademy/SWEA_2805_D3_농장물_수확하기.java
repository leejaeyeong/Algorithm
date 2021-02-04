package date0203;
import java.util.Scanner;

public class SWEA_D3_농장물_수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int sum = 0;
			int half = N / 2;
			
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = s.charAt(j) - '0';
					if (j - i <= half && j >= half - i && i <= half) {
						sum += arr[i][j];
					}
					else if (i > half && j >= i - half && j <= N - i + half -1) {
						sum += arr[i][j];
					}
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
/*
1
5
14054
44250
02032
51204
52212
*/