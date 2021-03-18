package date0319;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_집합의표현 {
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = stoi(st.nextToken());
		int m = stoi(st.nextToken());
		parents = new int[n+1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int oper = stoi(st.nextToken());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			
			switch(oper) {
			case 0:
				union(a,b);
				break;
			case 1:
				System.out.println(isSameSet(a,b));
				break;
			}
		}
	}
	static String isSameSet(int a, int b) {
		if (find(a) == find(b))
			return "YES";
		return "NO";
	}
	static int find(int x) {
		if (x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return;
		parents[bRoot] = parents[aRoot];
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
