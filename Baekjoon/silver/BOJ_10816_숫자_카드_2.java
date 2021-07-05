package date0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_10816_숫자_카드_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> numMap = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int n = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String num = st.nextToken();
			if (numMap.containsKey(num)) {
				numMap.put(num, numMap.get(num) + 1);
			} else {
				numMap.put(num, 1);
			}
		}
		
		int m = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			Integer val = numMap.get(st.nextToken());
			sb.append(val == null ? 0 : val);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
