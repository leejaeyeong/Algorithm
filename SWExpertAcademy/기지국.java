package AlgorithmAfter01;

import java.util.Scanner;

public class Solution_D3_IM_±âÁö±¹ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dy[] = {-1, 1, 0, 0};
		int dx[] = {0, 0, -1, 1};
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			char[][] arr = new char[N][N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next().toCharArray();
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 'X' || arr[i][j] == 'H') continue;
					
					for (int k = 0; k < 4; k++) {
						for (int l = 0; l < 3 - (int)('C' - 'A'); l++) {
							int y = i + dy[k] * (l + 1);
							int x = j + dx[k] * (l + 1);
							
							if (y < 0 || y >= N || x < 0 || x >= N) 
								continue; 
							
							if (arr[y][x] == 'H') {
								arr[y][x] = 'X';
							}
								
						}
					}
				}
			}
			
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 'H') {
						count++;
					}
				}
			}
			System.out.print("#" + t + " " + count);
			
		}
	}
}
/*
3
9
XXXXXXXXX
XXXHXXXXX
XXHAHXXHX
XXHHXXXXX
XXXXXXXXX
XXAHHXXXX
XXHXXHAHX
XXAHXXHXX
XXHXHXXXX

*/