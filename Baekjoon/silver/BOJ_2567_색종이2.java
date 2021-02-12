package date0212;
import java.util.Scanner;

public class BOJ_2567_색종이2 {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arr = new int[100][100];
		for (int t = 0; t < T; t++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			for (int i = r; i < r + 10; i++) {
				for (int j = c; j < c + 10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if (ny < 0 || ny >= 100 || nx < 0 || nx >= 100)
							continue;
						if (arr[ny][nx] == 0) {
							answer++;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}
