package date0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {
	static int[][] bingo;
	static Map<Integer, int[]> valMap;
	static int bingoCount;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		bingo = new int[5][5];
		valMap = new HashMap<>();
		bingoCount = 0;
		// 빙고판 입력
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
				valMap.put(bingo[i][j], new int[] {i,j});
			}
		}
		
		// 사회자가 부르는 숫자 입력
		int[] nums = new int[25];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				nums[i*5+j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 25; i++) {
			int y = valMap.get(nums[i])[0];
			int x = valMap.get(nums[i])[1];
			bingo[y][x] = -1;
			checking1(y, x);
			checking2(y, x);
			if (bingoCount >= 3) {
				System.out.println(i+1);
				return;
			}
		}
	} // end of main
	static void checking1(int y, int x) {
		int verCnt = 0;
		int horiCnt = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[y][i] == -1) verCnt++;
			if (bingo[i][x] == -1) horiCnt++;
		}
		if (verCnt == 5 && horiCnt ==5) {
			bingoCount += 2;
		} else if (verCnt == 5 || horiCnt == 5) {
			bingoCount += 1;
		}
	}
	static void checking2(int y, int x) {
		if (y == 2 && x == 2) {
			leftDownCheck();
			rightDownCheck();
		} else if (y == x) {
			leftDownCheck();
		} else if (5-1-y == x) {
			rightDownCheck();
		}
	}
	static void leftDownCheck() {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][i] == -1) cnt++;
		}
		if (cnt == 5) bingoCount++;
	}
	static void rightDownCheck() {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][5-1-i] == -1) cnt++; 
		}
		if (cnt == 5) bingoCount++;
	}
} // end of class 
