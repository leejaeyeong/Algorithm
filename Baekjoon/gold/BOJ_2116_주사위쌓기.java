package date0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116_주사위쌓기 {
	static int N, answer;
	static int[][] input;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][6];
		answer = 0;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 6; i++) { // 맨 처음
			int start = input[0][i]; // 첫 번째 주사위의 시작 값
			int max = 0;
			for (int j = 0; j < 6; j++) {
				if (j != i && j != getIndex(i)) 
					max = Math.max(max, input[0][j]);
			}
//			System.out.println("첫 주사위 시작값 : " + start);
//			System.out.println("마지막 인덱스 : " + i);
			answer = Math.max(answer,  max + dfs(1, start));
//			System.out.println("------------------");
		}
		System.out.println(answer);
	}
	static int dfs(int nextDice, int val) {
		if (nextDice == N) {
			return 0;
		}
//		int bottomIndex = topIndex;
//		topIndex = getIndex(topIndex);
		int index = -1;
		for (int i = 0; i < 6; i++) {
			if (val == input[nextDice][i]) {
				index = i;
				break;
			}
		}
		int maxDiceNum = 0;
		for (int i = 0; i < 6; i++) {
			if (i == index || i == getIndex(index)) 
				continue;
			maxDiceNum = Math.max(maxDiceNum, input[nextDice][i]);
			
		}
//		System.out.println("선택값 : " + maxDiceNum);
//		System.out.println("마지막 인덱스 : " + getIndex(index));
//		System.out.println("xxxxxxxxxxxx");
		return maxDiceNum + dfs(nextDice + 1, input[nextDice][getIndex(index)]);
	}
	static int getIndex(int index) {
		if (index == 0) { // 마주보는 인덱스 계산
			index = 5;
		} else if (index == 5) {
			index = 0;
		} else if (index <= 2) {
			index += 2;
		} else if (index > 2) {
			index -= 2;
		}
		return index;
	}
}
