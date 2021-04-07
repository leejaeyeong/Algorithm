package date0406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2858_기숙사바닥 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = stoi(st.nextToken());
		int b = stoi(st.nextToken());
		
		for (int i = 3; i <= r + b; i++) { // 세로 타일
			for (int j = 3; j <= r + b; j++) { // 가로 타일
				if (b == (i-2)*(j-2) && r + b == i * j) {
					System.out.println(j + " " + i);
					System.exit(0);
				}
			}
		}
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
