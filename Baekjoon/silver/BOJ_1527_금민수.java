package Test;

import java.util.Scanner;

public class BOJ_1527_금민수 {
	static int Max;
	static int Min;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Min = sc.nextInt();
		Max = sc.nextInt();
		dfs(0,0);
		System.out.println(count);
	}
	static void dfs(int depth, int num) {
		if (depth > 9) return;
		if (num > Max) return;
		if (num >= Min && num <= Max) 
			count++;
		depth++;
		dfs(depth, num * 10 + 4);
		dfs(depth, num * 10 + 7);
	}
}
