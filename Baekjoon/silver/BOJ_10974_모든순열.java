package Test;

import java.util.Scanner;

public class BOJ_10974_모든순열 {
	static int N;
	static int[] arr;
	static boolean[] checked;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		checked= new boolean[N];
		dfs(0);
	}
	static void dfs(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (checked[i-1]) continue;
			arr[cnt] = i;
			checked[i-1] = true;
			dfs(cnt + 1);
			checked[i-1] = false;
		}
	}
}
