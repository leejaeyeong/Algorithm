package date0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 비상연락망 {
	static int[][] arr;
	static int start, maxDepth, maxNum;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[101][101];
			visited = new boolean[101];
			maxDepth = Integer.MIN_VALUE;
			maxNum = Integer.MIN_VALUE;
			for (int i = 0; i < L / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to] = 1;
			}
			bfs();
			System.out.println("#" + t + " " + maxNum);
		}
	}
	static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		visited[start] = true;
		que.offer(new int[] {0, start}); // 깊이, 다음으로 탐색할 정점
		while (!que.isEmpty()) {
			int depth = que.peek()[0];
			int to = que.poll()[1];
			if (depth > maxDepth) {
				maxDepth = depth;
				maxNum = to;
			} else if (depth == maxDepth) {
				if (to > maxNum) {
					maxNum = to;
				}
			}
			
			for (int i = 1; i < 101; i++) {
				if (arr[to][i] != 0 && !visited[i]) {
					visited[i] = true;
					que.offer(new int[] {depth+1, i});
				}
			}
		}
	}
}






