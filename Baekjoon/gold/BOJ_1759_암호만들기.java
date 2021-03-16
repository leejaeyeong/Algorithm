package date0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	static char[] candidate, ret;
	static int L, C;
	static boolean[] selected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); // 만들어지는 문자열의 길이
		C = Integer.parseInt(st.nextToken()); // 후보 문자의 길이
		candidate = new char[C];
		selected = new boolean[C];
		ret = new char[L];
		candidate = br.readLine().replace(" ","").toCharArray();
		Arrays.sort(candidate);
		perm(0,0,0);
	}
	static void perm(int cnt, int moum, int jaum) {
		if (cnt == L) {
			if (moum < 1 || jaum < 2) {
				return;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < L; i++) {
				sb.append(ret[i]);
			}
			System.out.println(sb.toString());
			return;
		}
		for (int i = 0; i < C; i++) {
			if (selected[i]) continue;
			ret[cnt] = candidate[i];
			if (cnt != 0) {
				if ((int)ret[cnt-1] > (int)ret[cnt]) {
					continue;
				}
			}
			selected[i] = true;
			if ("aeiou".contains(Character.toString(ret[cnt]))) {
				perm(cnt+1, moum+1, jaum);
			} else {
				perm(cnt+1, moum, jaum+1);
			}
			selected[i] = false;
		}
	}
}
