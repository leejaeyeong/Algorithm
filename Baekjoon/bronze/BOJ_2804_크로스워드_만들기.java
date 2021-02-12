package date0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2804_크로스워드_만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		
		int aCross = -1;
		int bCross = -1;
		
		for (int i = 0; i < A.length() ; i++) {
			boolean check = false;
			for (int j = 0; j < B.length(); j++) {
				if (A.charAt(i) == B.charAt(j)) {
					aCross = i;
					bCross = j;
					check = true;
					break;
					
				}
			}
			if (check) break;
		}
		for (int i = 0; i < B.length(); i++) {
			for (int j = 0; j < A.length(); j++) {
				if (j == aCross) {
					System.out.print(B.charAt(i));
				}
				else if (i == bCross) {
					System.out.print(A.charAt(j));
				}
				else {
					System.out.print('.');
				}
			}
			System.out.println();
		}
	}
}
