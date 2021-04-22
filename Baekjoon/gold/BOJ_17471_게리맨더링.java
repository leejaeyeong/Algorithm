package date0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static int N;
	static int[] people;
	static boolean[][] connectMap;
	static boolean[] isSelected;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = stoi(br.readLine());
		people = new int[N+1];
		connectMap = new boolean[N+1][N+1];
		isSelected = new boolean[N+1];
		answer = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = stoi(st.nextToken()); // 각 구역시 인구수
		}
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int count = stoi(st.nextToken()); // i 번 정점과 연결되 정점의 개수
			if (count == 0) continue;
			for (int j = 0; j < count; j++) {
				int v = stoi(st.nextToken());
				connectMap[i][v] = true;
				connectMap[v][i] = true;
			}
		}
		
		subset(1, 0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	private static void subset(int cnt, int selectCount) {
		if (cnt == N) {
			if (selectCount == 0) return;
			ArrayList<Integer> listA = new ArrayList<>();
			ArrayList<Integer> listB = new ArrayList<>();
			
			for (int i = 1; i <= N; i++) {
				if (isSelected[i]) listA.add(i);
				else listB.add(i);
			}
			if (isConnectedArea(listA) && isConnectedArea(listB)) { // 연결가능한지 확인
				int sumA = 0;
				for (int i = 0; i < listA.size(); i++) {
					int v = listA.get(i);
					sumA += people[v];
				}
				int sumB = 0;
				for (int i = 0; i < listB.size(); i++) {
					int v = listB.get(i);
					sumB += people[v];
				}
				int diff = Math.abs(sumA - sumB);
				
				if (answer > diff) {
					answer = diff;
				}
			}
			return;
		}
		isSelected[cnt] = true;
		subset(cnt + 1, selectCount + 1);
		isSelected[cnt] = false;
		subset(cnt + 1, selectCount);
	}
	
	private static boolean isConnectedArea(ArrayList<Integer> list) {
		int start = list.get(0);
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		que.offer(start);
		visited[start] = true;
		
		while (!que.isEmpty()) {
			int from = que.poll();
			for (int i = 1; i <= N; i++) {
				if (connectMap[from][i] && !visited[i] && list.contains(i)) {
					visited[i] = true;
					que.offer(i);
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			int v = list.get(i);
			if (!visited[v]) // 연결되지 않은 정점이 있으면
				return false;
		}
		return true;
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
