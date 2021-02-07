package Test;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15655_N과M6 {
	static int[] input;
	static int[] answer;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		input = new int[N];
		answer = new int[M];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);
		combination(0, 0);
	}
	static void combination(int cnt, int index) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = index; i < N; i++) {
			answer[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	} 
}
