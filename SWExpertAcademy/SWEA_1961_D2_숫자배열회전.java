package date0203;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1961_숫자배열회전 {
	static int[][] rotate(int N, int[][] arr) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[j][N-i-1] = arr[i][j];
			}
		}
		return temp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) { // 배열 입력 받기
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			String[][] answer = new String[N][3]; // 정답을 담을 배열
			for (int i = 0; i < 3; i++) { // 로테이트
				arr = rotate(N, arr); 
				for (int j = 0; j < N; j++) {
					StringBuilder sb = new StringBuilder();
					for (int k = 0; k < N; k++) {
						sb.append(Integer.toString(arr[j][k])); // 열단위로 숫자 합침
					}
					answer[j][i] = sb.toString();
				}
			}
			
			System.out.println("#" + t);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(answer[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
