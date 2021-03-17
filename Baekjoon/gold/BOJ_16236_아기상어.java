package date0317;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	static int N;
	static int[][] sea;

//	static int[] shark = new int[4];  // 0 : x, 1 : y, 2 : size, 3 : eat
	static class Shark {
		int x, y, size = 2, eat;

		Shark(int y, int x) {
			this.y = y;
			this.x = x;
		}

		void eat() {
			sea[y][x] = 0; // 물고기를 먹기 전의 상어 좌표를 0으로
			y = fish[0];
			x = fish[1];
			if (size == ++eat) {
				size++;
				eat = 0;
			}
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Shark shark;
	static int[] fish; // 상어가 먹을 물고기
	static int moveCnt; // 상어가 물고기를 먹기 위해 움직인 총 시간

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		sea = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if (sea[i][j] == 9) {
					shark = new Shark(i, j);
				}
			}
		}
		while(bfs());
		System.out.println(moveCnt);
	}

	static boolean bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] { shark.y, shark.x }); // 탐색의 시작점은 상어 위치
		boolean[][] visited = new boolean[N][N];
		visited[shark.y][shark.x] = true;

		int level = 0; // 시간의 개념
		while (!que.isEmpty()) {
			int size = que.size(); // 현재 같은 레벨에 있는 크기를 나타낸다.(움직인 시간이 같은 애들 의미)
			level++;
			// 같은 레벨에 있는 애들만 돌린다.
			for (int i = 0; i < size; i++) {
				int y = que.peek()[0];
				int x = que.poll()[1];
				for (int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];

					if (ny < 0 || ny >= N || nx < 0 || nx >= N)
						continue;
					if (visited[ny][nx])
						continue;
					if (sea[ny][nx] > shark.size)
						continue;

					// 움직이는 것만 가능한 경우
					if (sea[ny][nx] == 0 || sea[ny][nx] == shark.size) {
						que.offer(new int[] { ny, nx });
						visited[ny][nx] = true;
					}
					// 먹을 수 있는 물고기인 경우
					else {
						// 처음 찾은 물고기일 때
						if (fish == null) {
							fish = new int[] { ny, nx };
						} else {
							if (fish[0] > ny || fish[0] == ny && fish[1] > nx) {
								fish[0] = ny;
								fish[1] = nx;
							}
						}
					}
				}
			}
			if (fish != null) {
				shark.eat();
				moveCnt += level;
				fish = null;
				return true;
			}
		}
		return false;
	}
}
