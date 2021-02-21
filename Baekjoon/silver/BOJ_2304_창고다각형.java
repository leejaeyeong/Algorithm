package date0221;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_2304_창고다각형 {
	static int[][] arr;
	static int N, highX, highHeight, answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N  = sc.nextInt();
		arr = new int[N][2];
		highX = Integer.MIN_VALUE;
		highHeight = 0;
		answer = 0;
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int height = sc.nextInt();
			arr[i] = new int[] {x, height};
			
			if (height > highHeight) { // 제일 높은 지점
				highHeight = height;
				highX = x;
			}
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		int index = getIndex(highX);
		answer += highHeight;
		solve(index, 0); // 왼쪽
		solve(index, 1); // 오른쪽
		System.out.println(answer);
	}
	static void solve(int index, int dir) {
		int nextHighX = -1, nextHeight = -1;
		if (dir == 0) { // 기준이 왼쪽이면
			for (int i = index-1; i >= 0; i--) {
				if (arr[i][1] > nextHeight) {
					nextHeight = arr[i][1];
					nextHighX = i; 
				}
			}
		} else { // 기준이 오른쪽
			for (int i = index+1; i < N; i++) {
				if (arr[i][1] > nextHeight) {
					nextHeight = arr[i][1];
					nextHighX = i; 
				}
			}
		}
		
		if (nextHighX == -1) 
			return;
		
		int currnetX = arr[index][0];
		int nextX = arr[nextHighX][0];
		answer += Math.abs(currnetX - nextX) * nextHeight;
		solve(nextHighX, dir);
	}
	static int getIndex(int x) {
		for (int i = 0; i < N; i++) {
			if (arr[i][0] == x)
				return i;
		}
		return -1;
	}
}
