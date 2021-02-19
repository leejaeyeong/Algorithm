package date0219;
import java.util.Scanner;

public class SWEA_1493_D3_수의새로운연산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arr = new int[400][400];
		
		// 맵 만들기
		for (int i = 1; i < 400; i++) {
			arr[i][1] = 1 + (i-1) * i / 2; // 계차수열
		}
		for (int i = 2; i < 400; i++) {
			for (int j = 1; j <= i - 1; j++) {
				arr[i-j][j+1] = arr[i-j+1][j] + 1; // 대각선으로 채우기
			}
		}
		
		for (int t = 1; t <= T; t++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int Py = -1;
			int Px = -1;
			int Qy = -1;
			int Qx = -1;
			for (int i = 1; i < 400; i++) {
				for (int j = 1; j <= i - 1; j++) {
					if (p == arr[i-j][j]) {
						Py = i-j;
						Px = j;
					}
					if (q == arr[i-j][j]) {
						Qy = i-j;
						Qx = j;
					}
					
					if ((Py ^ -1) != 0 && (Qy ^ -1) != 0) { // 둘다 초기값이 아니면
						break;
					}
				}
			}
			System.out.println("#" + t + " " + arr[Py + Qy][Px + Qx]);
		}
	}
}
