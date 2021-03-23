package date0323;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1786_찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] T = in.readLine().toCharArray();
		char[] P = in.readLine().toCharArray();

		int textLen = T.length;
		int patterLen = P.length;

		int[] fail = new int[patterLen];
		for (int i = 1, j = 0; i < patterLen; i++) {
			while (j > 0 && P[i] != P[j]) {
				j = fail[j - 1]; // 비교 문자가 다를 경우 이전 연속 지점으로 세팅
			}
			if (P[i] == P[j]) // 비교되는 문자가 같으면 j 포인터 증가
				fail[i] = ++j;
		}

		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// i : 텍스트 포인터 , j: 패턴 포인터
		for (int i = 0, j = 0; i < textLen; ++i) {

			while (j > 0 && T[i] != P[j])
				j = fail[j - 1];

			if (T[i] == P[j]) { // 두 글자 일치
				if (j == patterLen - 1) { // j가 패턴의 마지막 인덱스라면
					cnt++; // 카운트 증가
					list.add((i + 1) - patterLen + 1);
					j = fail[j];
				} else {
					j++;
				}
			}
		}
		System.out.println(cnt);
		StringBuilder sb = new StringBuilder();
		for (int index : list)
			sb.append(index + " ");
		System.out.println(sb.toString());
	}
}
