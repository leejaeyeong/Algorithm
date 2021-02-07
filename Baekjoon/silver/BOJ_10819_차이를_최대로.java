package Test;

import java.util.Scanner;

public class BOJ_10819_차이를_최대로 {
	static boolean[] visited;
	static int[] result;
	static int[] input;
	static int N;
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		result = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		dfs(0);
		System.out.println(max);
	}
	static void dfs(int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i ++) {
				sum += Math.abs(result[i] - result[i+1]);
			}
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			result[cnt] = input[i];
			visited[i] = true;
			dfs(cnt + 1);
			visited[i] = false;
		}
	}
}
