package date0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_4789_D3_성공적인_공연_기획 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int answer = 0; // 고용해야되는 사람
			String s = br.readLine();
			int[] arr = new int[s.length()];
			for (int i = 0; i < s.length(); i++) {
				arr[i] = s.charAt(i) - '0';
			}
			int currClap = arr[0];
			for (int i = 1; i < s.length(); i++) {
				if (currClap >= i) {
					currClap += arr[i];
					continue;
				}
				int add = i - currClap;
				// i 그 자체 보다 커야
				currClap += add;
				answer += add;
				i--;
			}
			System.out.println("#" + t + " " + answer);
		}
	}
}
