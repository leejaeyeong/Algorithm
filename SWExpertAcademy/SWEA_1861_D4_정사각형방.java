package Test;
import java.util.Scanner;

public class SWEA_1861_D4_정사각형방 {
	static int N;
	static int maxCount;
	static int startPositionNum;
	static boolean update;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] room;
	static boolean isValid(int y, int x) {
		if (y < 0 || y >= N || x < 0 || x >= N) // 범위를 벗어나면, 이미 방문햇으면 
			return false;
		return true;
	}
	static void searchRoom(int y, int x, int cnt) { // 좌표, 연속해서 몇 번 진행중인지 
		if (cnt >= maxCount) {
			update = true;
			maxCount = cnt;
		}
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (isValid(ny,nx) && (room[ny][nx] == (room[y][x] + 1))) {
				searchRoom(ny, nx, cnt + 1); 
				return;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			room = new int[N][N];
			
			
			
			for (int i = 0; i < N; i++) { // 방 정보 입력
				for (int j = 0; j < N; j++) {
					room[i][j] = sc.nextInt();
				}
			}
			maxCount = 0; // 연속 몇번?
			startPositionNum = 1001;
			for (int i = 0; i < N; i++) { // 방 순차적으로 탐색
				for (int j = 0; j < N; j++) {
					int currentMax = maxCount;
					update = false;
					searchRoom(i,j,1); // 좌표와, 몇 번째 연속해서 진행중인지
					if (update) {
						startPositionNum = currentMax == maxCount ? Math.min(startPositionNum, room[i][j]) : room[i][j]; 
						update = false;
					}
				}
			}
			System.out.println("#" + t + " " + startPositionNum + " " + maxCount);
		}
	}
}
