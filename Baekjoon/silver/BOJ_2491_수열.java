package date0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2491_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N-1; i++) {
			arr[i] = arr[i] - arr[i+1];
		}
		int upMaxCount = Integer.MIN_VALUE;
		int upCount = 0;
		for (int i = 0; i < N-1; i++) {
			if (arr[i] <= 0) {
				upCount++;
			} else {
				upMaxCount = Math.max(upMaxCount, upCount);
				upCount = 0;
			}
		}
		upMaxCount = Math.max(upMaxCount, upCount);
		int downMaxCount = Integer.MIN_VALUE;
		int downCount = 0;
		for (int i = 0; i < N-1; i++) {
			if (arr[i] >= 0) {
				downCount++;
			} else {
				downMaxCount = Math.max(downMaxCount, downCount);
				downCount = 0;
			}
		}
		downMaxCount = Math.max(downMaxCount, downCount);
		System.out.println(Math.max(upMaxCount + 1, downMaxCount+1));
	}
}
