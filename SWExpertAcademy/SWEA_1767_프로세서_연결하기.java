import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
	static int N, answer, coreCnt, maxConnectedCore, minLen;
	static int[][] candidate;
	static boolean[] isSelected;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			StringTokenizer st;
			coreCnt = 0; // 전체 코어의 개수
			maxConnectedCore = Integer.MIN_VALUE; // 연결된 코어의 수
			minLen = Integer.MAX_VALUE; // 코어의 길이 
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 && i != 0 && j != 0 && i != N-1 && j != N-1) 
						coreCnt++;
				}
			}
			int index = 0;
			isSelected = new boolean[coreCnt];
			candidate = new int[coreCnt][2];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && i != 0 && j != 0 && i != N-1 && j != N-1) {
						candidate[index++] = new int[] {i, j};
					}
				}
			}
			
			solve(0, map, 0);
			System.out.println("#" + t + " " + minLen);
		}
	}
	static void solve(int cnt, int[][] map, int connectedCore) {
		if (cnt == coreCnt) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 2) count++;
				}
			}
			if (maxConnectedCore < connectedCore) {
				maxConnectedCore = connectedCore;
				minLen = count;
			} else if (maxConnectedCore == connectedCore) {
				minLen = Math.min(minLen, count);
			}
			return;
		}
		isSelected[cnt] = true;
		int y = candidate[cnt][0];
		int x = candidate[cnt][1];
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny < 0 || ny >= N || nx < 0 || nx >= N)
				continue;
			if (map[ny][nx] == 2)
				continue;
			// 맵 복사
			int[][] tempMap = new int[N][N];
			copyMap(map, tempMap);
			// 채우는 함수
			if (fill(i, 2, tempMap, ny, nx)) {
				solve(cnt+1,tempMap, connectedCore+1);
			}
		}
		isSelected[cnt] = false;
		solve(cnt+1,map,connectedCore);
	}
	static void copyMap(int[][] src, int[][] dest) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dest[i][j] = src[i][j];
			}
		}
	}
	static boolean fill(int dr, int val, int[][] map, int y, int x) {
		switch(dr) {
		case 0: // 상
			for (int i = y; i >= 0; i--) {
				if (map[i][x] == 0) {
					map[i][x] = val;
				} else { // i가 0이 아닌 경우 
					for (int j = i+1; j <= y; j++) {
						map[j][x] = 0; // 되돌려놓기
					}
					return false;
				}
			}
			break;
		case 1: // 하
			for (int i = y; i < N; i++) {
				if (map[i][x] == 0) {
					map[i][x] = val;
				} else { // i가 0이 아닌 경우 
					for (int j = i-1; j >= y; j--) {
						map[j][x] = 0; // 되돌려놓기
					}
					return false;
				}
			}
			break;
		case 2: // 좌
			for (int i = x; i >= 0; i--) {
				if (map[y][i] == 0) {
					map[y][i] = val;
				} else {
					for (int j = i+1; j <= x; j++) {
						map[y][j] = 0;
					}
					return false;
				}
			}
			break;
		case 3: // 우
			for (int i = x; i < N; i++) {
				if (map[y][i] == 0) {
					map[y][i] = val;
				} else {
					for (int j = i-1; j >= x; j--) {
						map[y][j] = 0;
					}
					return false;
				}
			}
			break;
		}
		return true;
	}
}
