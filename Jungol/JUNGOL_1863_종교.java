package date0318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL_1863_종교 {
	static int N; 
	static int[] religionRelation;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); // 사람 수 
		int M = stoi(st.nextToken()); // 같은 종교 쌍의 수
		religionRelation = new int[N+1];
		for (int i = 1; i <= N; i++) {
			religionRelation[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			union(a,b);
		}
		int count = 0;
		boolean[] counted = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			if (i == religionRelation[i])
				count++;
		}
		System.out.println(count);
	}
	private static int find(int x) {
		if (religionRelation[x] == x) 
			return x;
		return religionRelation[x] = find(religionRelation[x]);
			
	}
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return;
		religionRelation[aRoot] = religionRelation[bRoot];
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
