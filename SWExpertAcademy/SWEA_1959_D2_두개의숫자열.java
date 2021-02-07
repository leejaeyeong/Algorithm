package Test;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1959_D2_두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr1 = new int[N];
			int[] arr2 = new int[M];
			
			for (int i = 0; i < N; i++) {
				arr1[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				arr2[i] = sc.nextInt();
			}
			
			if (N > M) { // arr2를 긴 배열로
				int[] temp = arr1;
				arr1 = arr2;
				arr2 = temp;
			}
			
			int max = 0;
			int distance = Math.abs(N-M);
			int len = Math.min(N,M);
			for (int i = 0; i <= distance; i++) {
				int sum = 0;
				for (int j = i; j < i + len; j++) {
					sum += arr2[j] * arr1[j-i];
				}
				max = Math.max(sum, max);
			}
			System.out.println("#" + t + " " + max);
					
		}
	}
}
