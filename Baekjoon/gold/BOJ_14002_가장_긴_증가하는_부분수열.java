package date0325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14002_가장_긴_증가하는_부분수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = stoi(st.nextToken());
		}
		int[] lis = new int[n];
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		
		// 최댓값과 인덱스 찾기
		int maxLengthIdx = 0;
		int maxLength = 0;
		for (int i = 0; i < n; i++) {
			if (maxLength < lis[i]) {
				maxLengthIdx = i;
				maxLength = lis[i];
			}
		}
		
		int[] answer = new int[maxLength];  
		int[] select = new int[maxLength];
		answer[maxLength-1] = arr[maxLengthIdx]; // 뽑은 숫자
		select[maxLength-1] = lis[maxLengthIdx]; // 뽑은 lis 값
		for (int i = maxLength-2; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				// 이전에 뽑았던 최대 길이, 원소 값 보다 작은 요소 중 최대 값 찾기
				if (lis[j] > select[i] && lis[j] < select[i+1] && arr[j] < answer[i+1]) {
					select[i] = lis[j];
					answer[i] = arr[j];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(maxLength).append("\n");
		for (int i = 0; i < answer.length; i++) {
			sb.append(answer[i]).append(" ");;
		}
		System.out.println(sb.toString());

	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
