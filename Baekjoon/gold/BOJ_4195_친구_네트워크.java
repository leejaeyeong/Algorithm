package date0325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_4195_친구_네트워크 {
	static int[] parents, state;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringTokenizer st;
		Map<String,Integer> friendMap = new HashMap<>();
		String[][] info;
		int index = 0;
		for (int t = 1; t <= T; t++) {
			int m = stoi(br.readLine());
			info = new String[m][2];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				info[i][0] = st.nextToken();
				info[i][1] = st.nextToken();
				if (!friendMap.containsKey(info[i][0]))
					friendMap.put(info[i][0], index++);
				if (!friendMap.containsKey(info[i][1]))
					friendMap.put(info[i][1], index++);
			}
			
			N = friendMap.size();
			parents = new int[N];
			state = new int[N];
			Arrays.fill(state, 1);
			make();
			for (int i = 0; i < m; i++) {
				int p1 = friendMap.get(info[i][0]);
				int p2 = friendMap.get(info[i][1]);
				union(p1, p2);
				System.out.println(state[find(p1)]);
			}
		}
	}
	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return;		
		parents[bRoot] = aRoot;
		state[aRoot] += state[bRoot];
	}
	
	private static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
