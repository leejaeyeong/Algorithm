package date0328;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크_연결 {
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = stoi(br.readLine());
		int m = stoi(br.readLine());
		
		int[][] edgeList = new int[m][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = stoi(st.nextToken());
			int to = stoi(st.nextToken());
			int weight = stoi(st.nextToken());
			edgeList[i] = new int[] {from, to, weight};
		}
		Arrays.sort(edgeList,(e1, e2) -> e1[2] - e2[2]);
		parents = new int[n+1];
		make();
		int count = 0;
		int res = 0;
		for (int i = 0; i < m; i++) {
			if (union(edgeList[i][0], edgeList[i][1])) {
				res += edgeList[i][2];
				if (++count == n-1) break;
			}
		}
		System.out.println(res);
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
	private static void make() {
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}
	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true; 
	}

	
}
