package date0407;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BOJ_1339_단어수학 {
	static Map<String, Integer> map;
	static Set<Character> alphaSet;
	static boolean[] checked;
	static int n, N, answer = Integer.MIN_VALUE;
	static int[] result;
	static char[][] data;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		data = new char[n][];
		
		alphaSet = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			data[i] = br.readLine().toCharArray();
			for (int j = 0; j < data[i].length; j++) {
				alphaSet.add(data[i][j]);
			}
		}
		N = alphaSet.size();
		checked = new boolean[N];
		result = new int[N];
		perm(0);
		System.out.println(answer);
	}
	static void perm(int cnt) {
		if (cnt == N) {
			sum(result);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (checked[i]) continue;
			checked[i] = true;
			result[cnt] = 9 - i;
			perm(cnt + 1);
			checked[i] = false;
		}
	}
	static void sum(int[] result) {
		Map<Character, Integer> alphaMap = new HashMap<>();
		int idx = 0;
		for (Character c : alphaSet) {
			alphaMap.put(c, result[idx++]);
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int sub = 0; 
			idx = 1;
			for (int j = data[i].length-1; j >= 0; j--) {
				sub += alphaMap.get(data[i][j]) * idx;
				idx *= 10;
			}
			sum += sub;
		}
		if (sum > answer)
			answer = sum;
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
