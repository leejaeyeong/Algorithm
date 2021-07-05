package date0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1181_단어정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = stoi(br.readLine());
		String[] arr = new String[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
		});
		
		StringBuilder sb = new StringBuilder();
		String prev = "";
		for (int i = 0; i < n; i++) {
			if (prev.equals(arr[i])) continue;
			sb.append(arr[i] + "\n");
			prev = arr[i];
		}
		System.out.println(sb.toString());
	} 

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
