package date0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터_큐 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = stoi(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int count = stoi(st.nextToken());
			int loc = stoi(st.nextToken());
			int target = -1;
			
			st = new StringTokenizer(br.readLine());
			int[] countOfPriority = new int[10];
			Queue<Integer> que = new LinkedList<>();
			
			for (int j = 0; j < count; j++) {
				int priority = stoi(st.nextToken());
				countOfPriority[priority]++;
				que.offer(priority);
			}
			
			int result = 0;
			next : while(true) {
				int print = que.poll();
				
				for (int j = 9; j >= 1; j--) {
					if (countOfPriority[j] > 0 && print < j) {
						que.offer(print);
						if (loc == 0) loc = que.size() - 1;
						else loc--;
						continue next;
					}
				}
				
				result++;
				if (loc == 0) {
					break;
				}
				loc--;
				countOfPriority[print]--;
			}
			System.out.println(result);
		}
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
