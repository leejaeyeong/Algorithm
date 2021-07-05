package date0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866_요세푸스_문제_0 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = stoi(st.nextToken());
		int k = stoi(st.nextToken());
		Queue<Integer> que = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= n; i++) {
			que.add(i);
		}
		
		while(!que.isEmpty()) {
			for (int i = 0; i < k - 1; i++) {
				que.offer(que.poll());
			}
			sb.append(que.poll());
			if (!que.isEmpty()) {
				sb.append(", ");
			}
					
		}
		System.out.println("<" + sb.toString() + ">");
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}	
