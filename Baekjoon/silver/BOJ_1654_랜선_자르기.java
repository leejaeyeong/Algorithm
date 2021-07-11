package date0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654_랜선_자르기 {
	static long ans = Long.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = stoi(st.nextToken());
		int n = stoi(st.nextToken());
		long max = Long.MIN_VALUE;
		int[] arr = new int[k];
		
		for (int i = 0; i < k; i++) {
			arr[i] = stoi(br.readLine());
			max = Math.max(max, arr[i]);
		}
		search(1, max, arr, n);
		System.out.println(ans);
	}

	private static void search(long left, long right, int[] arr, int n) {
		if (left > right) return;
		long mid = (left + right) / 2;
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i] / mid;
		}
		
		if (sum >= n) {
			if (ans < mid) {
				ans = mid;
			}
			search(mid + 1, right, arr, n);
		} else {
			search(left, mid - 1, arr, n);
		}
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}	
