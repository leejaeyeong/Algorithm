package Test;

import java.util.Scanner;

public class BOJ_2798_블랙잭 {
	static int[] data;
	static int[] numbers;
	static int N;
	static int target;
	static int max = 0;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		target = sc.nextInt();
		numbers = new int[3];
		data = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		permutation(0);
		System.out.println(max);
	}
	static void permutation(int cnt) {
		if (cnt == 3) {
			int sum = numbers[0] + numbers[1] + numbers[2];
			if (sum <= target && sum >= max) {
				max = sum;
			}
			return;
		}
		
		for (int i = cnt; i < N; i++) {
			if (visited[i]) continue;
			numbers[cnt] = data[i];
			visited[i] = true;
			permutation(cnt + 1);
			visited[i] = false;
		}
	}
}
