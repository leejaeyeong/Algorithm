package date0210;

import java.util.Scanner;

public class BOJ_16935_배열돌리기3 {
	static int[][] arr;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt(); // 수행 연산의 수
		
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int[] command = new int[R];
		for (int i = 0; i < R; i++) {
			command[i] = sc.nextInt();
		}
		for (int i = 0; i < R; i++) {
			switch(command[i]) {
			case 1:
				reverseTopAndBottom();
				break;
			case 2:
				reverseLeftAndRight();
				break;
			case 3:
				rotate90();
				break;
			case 4:
				for (int k = 0; k < 3; k++) {
					rotate90();
				}
				break;
			case 5:
				divide();
				break;
			case 6:
				for (int k = 0; k < 3; k++) {
					divide();
				}
				break;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		} 
	}
	static void reverseTopAndBottom() { // 상하반전
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[N-i-1][j] = arr[i][j];
			}
		}
		arr = temp;
	}
	static void reverseLeftAndRight() { // 좌우반전
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][M-j-1];
			}
		}
		arr = temp;
	}
	static void rotate90() {
		//int r = arr[0].length, c = arr.length;
		int[][] temp = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[j][N-1-i] = arr[i][j]; 
			}
		}
		int t = N;
		N = M;
		M = t;
		arr = temp;
	}
	static void divide() {
		int NN = N / 2, MM = M / 2;
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < M; j++) {
				if (i < NN && j < MM) { // 영역 1
					temp[i][j] = arr[NN+i][j];
				} else if (i < NN && j >= MM) { // 영역 2
					temp[i][j] = arr[i][j-MM];
				} else if (i >= NN && j < MM) { // 영역 3
					temp[i][j] = arr[i][j+MM];
				} else { // 영역 4
					temp[i][j] = arr[i-NN][j];
				}
			}
		}
		arr = temp;
	}
}
