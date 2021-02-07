package Test;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15663_N과M9 {
	static int N;
	static int M;
	static int[] numbers;
	static boolean[] visited;
	static int[] input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		numbers = new int[M];
		Arrays.sort(input);
		combi(0);
		System.out.println(sb.toString());
	}
	static StringBuilder sb = new StringBuilder();
	static void combi(int cnt) {
		
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		int prev = -1;
		for (int i = 0; i < N; i++) {
			if (visited[i] || input[i] == prev) continue;
			visited[i] = true;
			numbers[cnt] = prev = input[i];
			combi(cnt+1);
			visited[i] = false;
		}
	}
}
