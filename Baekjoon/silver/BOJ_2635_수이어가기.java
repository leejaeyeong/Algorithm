package date0226;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2635_수이어가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		StringBuilder sb;
		String save = ""; 
		
		for (int num = N/2; num <= N; num++) {
			sb = new StringBuilder();
			sb.append(N + " ");
			sb.append(num + " ");
			int cnt = 2;
			int prevPrevVal = N;
			int prevVal = num;
			while (true) {
				int target = prevPrevVal - prevVal;
				if (target >= 0) {
					prevPrevVal = prevVal;
					prevVal = target;
					sb.append(target + " ");
					cnt++;
					continue;
				}
				if (cnt > max) {
					max = cnt;
					save = new String(sb.toString());
				}
				break;
			}
		}
		System.out.println(max);
		System.out.println(save);
	}
}
