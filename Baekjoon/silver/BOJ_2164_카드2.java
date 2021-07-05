package date0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		boolean isThrough = true;
		
		Queue<Integer> que = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			que.offer(i);
		}
		while(que.size() != 1) {
			if (isThrough) {
				que.poll();
				isThrough = !isThrough;
				continue;
			}
			que.offer(que.poll());
			isThrough = !isThrough;
		}
		System.out.println(que.poll());

	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
