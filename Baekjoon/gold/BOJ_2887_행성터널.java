package date0329;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2887_행성터널 {
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
	static int N;
	static Edge[] edgeList;
	static int[] parents;
	static int[][] locX, locY, locZ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		StringTokenizer st;
		edgeList = new Edge[(N-1)*3]; // 노드 개수에 따른 간선의 수 * (x, y, z 축)
		locX = new int [N][2];
		locY = new int [N][2];
		locZ = new int [N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			locX[i] = new int[] {i,stoi(st.nextToken())}; // 노드 번호, 좌표입력
			locY[i] = new int[] {i,stoi(st.nextToken())};
			locZ[i] = new int[] {i,stoi(st.nextToken())};
		}
		// 각 기준 축 별로 오름차순 정렬
		Arrays.sort(locX,(a, b) -> a[1] - b[1]); 
		Arrays.sort(locY,(a, b) -> a[1] - b[1]);
		Arrays.sort(locZ,(a, b) -> a[1] - b[1]);
		int index = 0;
		for (int i = 0; i < N-1; i++) {
			edgeList[index++] = new Edge(locX[i][0], locX[i+1][0], Math.abs(locX[i][1] - locX[i+1][1]));
			edgeList[index++] = new Edge(locY[i][0], locY[i+1][0], Math.abs(locY[i][1] - locY[i+1][1]));
			edgeList[index++] = new Edge(locZ[i][0], locZ[i+1][0], Math.abs(locZ[i][1] - locZ[i+1][1]));
		}
		Arrays.sort(edgeList); // 길이가 짧은 순으로 정렬
		makeSet();
		
		int res = 0, count = 0;
		for (int i = 0; i < edgeList.length; i++) {
			if (union(edgeList[i].from, edgeList[i].to)) { // 
				res += edgeList[i].weight;
				if (++count == N-1) break;
			}
		}
		System.out.println(res);
	}

	private static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	private static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = parents[aRoot];
		return true;
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
