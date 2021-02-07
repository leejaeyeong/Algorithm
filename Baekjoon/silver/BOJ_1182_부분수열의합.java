package Test;
import java.util.Scanner;

public class BOJ_1182_부분수열의합 {
	static int[] arr;
	static int[] checked;
	static int totalCnt;
	static int N;
	static int S;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		checked = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		subset(0);
		System.out.println(totalCnt);
	}
	static void subset(int cnt) {
		if (cnt == N) {
			int sum = 0;
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (checked[i] == 1) {
					sum += arr[i];
					count++;
				}
			}
			if (sum == S && count > 0) {
				totalCnt++;
			}
			return;
		}
		
		checked[cnt] = 1;
		subset(cnt+1);
		checked[cnt] = 0;
		subset(cnt+1);
	}
}
