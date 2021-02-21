package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 딱지놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st1;
		StringTokenizer st2;
		for (int i = 0; i < N; i++) {
			int[] player1 = new int[4];
			int[] player2 = new int[4];
			st1 = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			st1.nextToken();
			st2.nextToken();
			int inputCount1 = st1.countTokens();
			int inputCount2 = st2.countTokens();
			
			for (int j = 0; j < inputCount1; j++) {
				int val = Integer.parseInt(st1.nextToken());
				player1[val-1] += 1;
			}
			for (int j = 0; j < inputCount2; j++) {
				int val = Integer.parseInt(st2.nextToken());
				player2[val-1] += 1;
			}
			
			for (int j = 0; j < 4; j++) {
				if (player1[4-j-1] > player2[4-j-1]) {
					System.out.println("A");
					break;
				} else if (player1[4-j-1] < player2[4-j-1]) {
					System.out.println("B");
					break;
				}
				if (j == 3)
					System.out.println("D");
			}
		}
	}
}
