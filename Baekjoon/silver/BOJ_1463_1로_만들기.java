package date0324;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463_1로_만들기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = stoi(br.readLine());
		int[] arr = new int[N+3];
		arr[1] = 0;
		arr[2] = arr[3] = 1;
		if (N <= 3) {
			System.out.println(arr[N]);
			return;
		}
		for (int i = 4; i <= N; i++) {
			arr[i] = Integer.MAX_VALUE;
		}
		for (int i = 4; i <= N; i++) {
			if (i % 3 == 0) arr[i] = arr[i / 3] + 1;
			if (i % 2 == 0) arr[i] = Math.min(arr[i], arr[i / 2] + 1);
			arr[i] = Math.min(arr[i-1]+1, arr[i]);
		}
		System.out.println(arr[N]);

	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
