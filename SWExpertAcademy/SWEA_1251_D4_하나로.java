package date0324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SWEA_1251_D4_하나로 {
	static int minCost;
	static int[] parents;
	static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;
		Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	static class Node {
		int y, x;
		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			int N = stoi(br.readLine());
			int E = (N - 1) * N / 2; // 가능한 간선의 수
			Edge[] edgeList = new Edge[E];
			int[] yList = new int[N];
			int[] xList = new int[N];
			
			// 좌표 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				xList[i] = stoi(st.nextToken()); 
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				yList[i] = stoi(st.nextToken()); 
			}
			
			// 노드 추가
			Node[] nodeList = new Node[N];
			for (int i = 0; i < N; i++) {
				nodeList[i] = new Node(yList[i], xList[i]);
			}
			
			// 가능한 정보 간선 추가
			int index = 0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i + 1; j < N; j++) {
					// 환경 세율 계산할 때 제곱하므로 루트를 없애줌
					double weight = Math.pow(Math.abs(nodeList[i].y - nodeList[j].y), 2) + Math.pow(Math.abs(nodeList[i].x - nodeList[j].x), 2);
					edgeList[index++] = new Edge(i,j,weight);
				}
			}
			
			double e = Double.parseDouble(br.readLine());
			
			Arrays.sort(edgeList);
			
			// make 
			parents = new int[N];
			for (int i = 0; i < N; i++) {
				parents[i] = i;
			}
			double result = 0; // 가중치의 합
			int count = 0;
			
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					result += edge.weight; // 간선의 길이를 구할 때 루트 처리를 안해줬기 때문에 제곱하지 않음
					if (++count == N-1) break;
				}
			}
			System.out.println("#" + t + " " + Math.round(result*e));
		}

	}
	static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]);
	}
	static boolean union(int a, int b) {
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
