package date0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5550_D4_나는_개구리로소이다 {
	static int[] check;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		char[] croak = {'c', 'r', 'o', 'a', 'k'};
		for (int t = 1; t <= T; t++) {
			String frog = br.readLine();
			check = new int[5];
			boolean state = true;
			int maxFrogCnt = 0; 
			for (int i = 0; i < frog.length(); i++) {
				maxFrogCnt = Math.max(maxFrogCnt, check[0]); // 동시에 소리내는 개구리의 최대 수
				int lastIndex = -1;
				for (int j = 0; j < 5; j++) { // croak 체크
					if (croak[j] == frog.charAt(i)) {
						check[j]++;
						lastIndex = j;
						break;
					}
				}
				if (lastIndex > 0 && check[lastIndex] > check[lastIndex-1]) { // 이전 문자보다 횟수가 더 많으면
					state = false;
					break;
				}
				if (croak[lastIndex] == 'k') { // 마지막 문자이면 
					reduce();
				}
			}
			if (!isPossible()) { // 소리를 다 냈는지 확인
				state = false;
			}
			System.out.print("#" + t + " ");
			if (state) System.out.println(maxFrogCnt);
			else System.out.println(-1);
		}
	}
	static void reduce() {
		for (int i = 0; i < 5; i++) --check[i];
	}
	static boolean isPossible() {
		for (int i = 0; i < 5; i++) {
			if (check[i] != 0) 
				return false;
		}
		return true;
	}
}
