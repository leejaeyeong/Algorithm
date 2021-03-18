package date0318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_D4_서로소집합 {
	static int[] state;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb;
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#" + t + " ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 주어지는 a와 b는 m 이하의 수
			int m = Integer.parseInt(st.nextToken()); // 연산의 ㅐ수 
			state = new int[n+1];
			
			// make
			for (int i = 0; i < n; i++) {
				state[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int operator = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch(operator) {
				case 0 : // 합친다
					union(a,b);
					break;
				case 1: // 같은 집합에 속하는지 확인 
					sb.append(isSameSet(a,b));
					break;
				}
			}
			System.out.println(sb.toString());
		}
	}
	static String isSameSet(int a, int b) {
		if (find(a) == find(b))
			return "1";
		return "0";
	}
	static int find(int x) {
		if (x == state[x])
			return x;
		return state[x] = find(state[x]);
	}
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return;
		state[aRoot] = state[bRoot];
	}
}	
