package date0305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1449_수리공_항승 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int answer = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int index = 0;
		double tapeLength = 0;
		while (index < N) {
			System.out.println(tapeLength);
			if (tapeLength < arr[index]) {
				tapeLength = arr[index] - 0.5 + L; // 길이 연장
				answer++;
				continue;
			}
			if (arr[index] + 0.5 <= tapeLength) {
				index++;
			}
		}
		System.out.println(answer);
	}
}
