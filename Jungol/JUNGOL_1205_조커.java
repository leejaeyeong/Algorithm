package date0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL_1205_조커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int maxVal = Integer.MIN_VALUE;
		int joker = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == 0) joker++;
		}
		if (joker == N) { // 전부 조커이면
			System.out.println(N);
			return;
		}
		Arrays.sort(arr);
		for (int i = joker; i < N; i++) { // 조커가 아닌 인덱스부터 시작
			int tempJoker = joker; // 사용가능한 조커
			int tempCnt = 1; // 연속된 수
			int currentNum = arr[i]; // 최근 수
			for (int j = i+1; j < N; j++) {
				if (currentNum == arr[j]) continue; // 같은 수이면 스트레이트 조합에 구성안함
				if (currentNum+1 == arr[j]) { 
					tempCnt++;
					currentNum = arr[j]; // 최근 값 변경
					continue;
				}
				if (tempJoker == 0) break;
				tempJoker--; // 조커 사용
				currentNum++; // 값 증가
				tempCnt++; // 연속된 수 증가
				j--; // 값 변경후 제 자리 체크를 위해 감소
			}
			maxVal = Math.max(maxVal, tempCnt + tempJoker);
		}
		System.out.println(maxVal);
	}
}
