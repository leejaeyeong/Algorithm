package date0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1436_영화감독숌 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		
		int val = 666;
		int cnt = 0;
		while(true) {
			String sVal = Integer.toString(val);
			for (int i = 0; i < sVal.length() - 2; i++) {
				char s1 = sVal.charAt(i);
				char s2 = sVal.charAt(i + 1);
				char s3 = sVal.charAt(i + 2);
				if (s1 == s2 && s1 == s3 && s1 == '6') {
					cnt++;
					break;
				}
			}
			
			if (cnt == n) {
				System.out.println(val);
				break;
			}
			val++;
		}

	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
