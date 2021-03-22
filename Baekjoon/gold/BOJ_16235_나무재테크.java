package date0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {
	static class Tree implements Comparable<Tree> {
		int y, x, age;
		public Tree(int y, int x, int age) {
			this.y = y;
			this.x = x;
			this.age = age;
		}
		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
	static int N, M, K;
	static int[][] energy, groundState;
	static PriorityQueue<Tree> treeList;
	static ArrayList<Tree> deathTreeList;
	static int[] dy = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		treeList = new PriorityQueue<>();
		energy = new int[N+1][N+1]; // 얼마나 추가되어야되는지 나타내는 맵
		groundState = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				energy[i][j] = stoi(st.nextToken());
				groundState[i][j] = 5;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = stoi(st.nextToken());
			int x = stoi(st.nextToken());
			int age = stoi(st.nextToken());
			treeList.offer(new Tree(y,x,age));
		}
		
		for (int i = 0; i < K; i++) { // 년 수 만큼 실행
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(treeList.size());
	}
	private static void spring() {
		int treeCnt = treeList.size();
		deathTreeList = new ArrayList<>();
		ArrayList<Tree> tempList = new ArrayList<>();
		for (int i = 0; i < treeCnt; i++) {
			Tree tree = treeList.poll();
			if (tree.age <= groundState[tree.y][tree.x]) {
				groundState[tree.y][tree.x] -= tree.age;
				tree.age++;
				tempList.add(tree);
			} else { // 나무가 양분을 못먹고 죽는 경우
				deathTreeList.add(tree);
			}
		}
		treeList.addAll(tempList);
	}
	private static void summer() {
		for (int i = 0; i < deathTreeList.size(); i++) {
			Tree tree = deathTreeList.get(i);
			int power = tree.age / 2;
			groundState[tree.y][tree.x] += power;
		}
	}
	private static void fall() {
		int treeCnt = treeList.size();
		ArrayList<Tree> tempList = new ArrayList<>();
		ArrayList<Tree> originList = new ArrayList<>();
		for (int i = 0; i < treeCnt; i++) {
			Tree tree = treeList.poll();
			if (tree.age % 5 == 0) { // 5의 배수이면
				int y = tree.y;
				int x = tree.x;
				for (int j = 0; j < 8; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					
					if (ny < 1 || ny > N || nx < 1 || nx > N) continue;
					tempList.add(new Tree(ny,nx,1));
				}
			}
			originList.add(tree);
		}
		treeList.addAll(originList);
		treeList.addAll(tempList);
	}
	private static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				groundState[i][j] += energy[i][j];
			}
		}
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
