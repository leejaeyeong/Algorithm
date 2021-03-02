package date0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_11545_D4_틱택톰 {
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			arr = new char[4][4];
			for (int i = 0; i < 4; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			br.readLine();
			if (check('X')) {
				System.out.println("#" + t + " X won");
			} else if (check('O')) {
				System.out.println("#" + t + " O won");
			} else if (isFull()) {
				System.out.println("#" + t + " Draw");
			} else {
				System.out.println("#" + t + " Game has not completed");
			}
		}
	}
	static boolean isFull() {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (arr[i][j] == '.') break;
				cnt++;
			}
		}
		if (cnt == 16)
			return true;
		return false;
	}
	static boolean check(char ch) {
		// 가로, 세로 체크
		for (int i = 0; i < 4; i++) {
			int rowCnt = 0, colCnt = 0;
			for (int j = 0; j < 4; j++) {
				if (arr[i][j] == ch || arr[i][j] == 'T') rowCnt++;
				if (arr[j][i] == ch || arr[j][i] == 'T') colCnt++;
			}
			if (rowCnt == 4 || colCnt == 4) {
				return true;
			}
		}
		// 대각선 체크
		int leftDownCnt = 0, rightDownCnt = 0;
		for (int i = 0; i < 4; i++) {
			if (arr[i][i] == ch || arr[i][i] == 'T') leftDownCnt++;
			if (arr[i][4-i-1] == ch || arr[i][4-i-1] == 'T') rightDownCnt++;
		}
		if (leftDownCnt == 4 || rightDownCnt == 4) {
			return true;
		}
		return false;
	}
}
