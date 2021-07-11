package date0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_수_정렬하기3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = stoi(br.readLine());
		}
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb.toString());

	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
