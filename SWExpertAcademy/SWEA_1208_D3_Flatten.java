package Algorithm0202;

import java.util.Scanner;

public class SWEA_1208_D3_Flatten {
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int dump = sc.nextInt();
			arr = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				int height = sc.nextInt(); // 블록의 높이 , hegiht - 1
				for (int j = 0; j < height; j++) {
					arr[j][i] = 1;
				}
			}
			int a = -1, b = -1;
			int c = -1, d = -1;
			for (int i = 0; i < dump; i++) {
				for (int j = 99; j >= 0; j--) {
					boolean isCheck = false;
					for (int k = 0; k < 100; k++) {
						if (arr[j][k] == 1) {
							a = j;
							b = k;
							isCheck = true;
						}
					}
					if (isCheck)
						break;
				}
				
				for (int j = 0; j < 100; j++) {
					boolean isCheck = false;
					for (int k = 0; k < 100; k++) {
						if (arr[j][k] == 0) {
							c = j;
							d = k;
							isCheck = true;
						}
					}
					if (isCheck)
						break;
				}
				
				arr[a][b] = 0;
				arr[c][d] = 1;
			}
			
			int min = 100;
			int max = -1;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (arr[i][j] == 0) {
						min = Math.min(min, i);
					}
					else if (arr[i][j] == 1) {
						max = Math.max(max, i);
					}
				}
			}
			System.out.println("#" + t + " " + (max - min + 1));
		}
	}
}

/*
834
42 68 35 1 70 25 79 59 63 65 6 46 82 28 62 92 96 43 28 37 92 5 3 54 93 83 22 17 19 96 48 27 72 39 70 13 68 100 36 95 4 12 23 34 74 65 42 12 54 69 48 45 63 58 38 60 24 42 30 79 17 36 91 43 89 7 41 43 65 49 47 6 91 30 71 51 7 2 94 49 30 24 85 55 57 41 67 77 32 9 45 40 27 24 38 39 19 83 30 42

617
16 40 59 5 31 78 7 74 87 22 46 25 73 71 30 78 74 98 13 87 91 62 37 56 68 56 75 32 53 51 51 42 25 67 31 8 92 8 38 58 88 54 84 46 10 10 59 22 89 23 47 7 31 14 69 1 92 63 56 11 60 25 38 49 84 96 42 3 51 92 37 75 21 97 22 49 100 69 85 82 35 54 100 19 39 1 89 28 68 29 94 49 84 8 22 11 18 14 15 10
*/
