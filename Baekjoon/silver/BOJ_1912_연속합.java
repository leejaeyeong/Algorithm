package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] temp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = st.countTokens();
		for (int i = 0; i < count; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		temp[0] = arr[0];
		for (int i = 1; i < N; i++) {
			temp[i] = Math.max(arr[i], temp[i-1] + arr[i]);
		}
		Arrays.sort(temp);
		System.out.println(temp[N-1]);
	}
}
	