package date0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10866_덱 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new ArrayDeque<>();
		int n = stoi(br.readLine());
		String cmd = null;
		int val = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			if (st.countTokens() == 1) {
				val = stoi(st.nextToken());
			}
			
			switch(cmd) {
			case "push_front":
				deque.addFirst(val);
				break;
			case "push_back":
				deque.addLast(val);
				break;
			case "pop_front": 
				if (deque.isEmpty()) sb.append("-1\n");
				else sb.append(deque.pollFirst() + "\n");
				break;
			case "pop_back":
				if (deque.isEmpty()) sb.append("-1\n");
				else sb.append(deque.pollLast() + "\n");
				break;
			case "size":
				sb.append(deque.size() + "\n");
				break;
			case "empty":
				if (deque.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "front":
				if (deque.isEmpty()) sb.append("-1\n");
				else sb.append(deque.getFirst() + "\n");
				break;
			case "back":
				if (deque.isEmpty()) sb.append("-1\n");
				else sb.append(deque.getLast() + "\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
