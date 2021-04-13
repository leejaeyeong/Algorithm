package date0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_활주로건설2 {
	static int N, X;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			X = stoi(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = stoi(st.nextToken());
				}
			}
			System.out.println("#" + t + " " + process());
		}

	}

	private static int process() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (makeRoad(map[i])) ++count;
			int[] temp = new int[N];
			for (int j = 0; j < N; j++) {
				temp[j] = map[j][i];
			}
			if (makeRoad(temp)) ++count;
		}
		return count;
	}
	private static boolean makeRoad(int[] road) {
		int beforeHeight = road[0];
		int size = 0; // 연속된 땅이 높이의 수
		int j = 0; // 탐색 열 위치
		while (j < N) {
			if (beforeHeight == road[j]) {
				++size;
				++j;
			} else if (beforeHeight + 1 == road[j]) {
				if (size < X) return false;
				beforeHeight++;
				size = 1;
				++j;
			} else if (beforeHeight - 1 == road[j]) {
				int count = 0;
				for (int k = j; k < N; k++) {
					if (road[k] != beforeHeight-1) break;
					if (++count == X) break;
				}
				if (count < X) return false; // 경사로 설치 불가 
				beforeHeight--;
				size = 0;
				j += X;
			} else {
				return false;
			}
		}
		return true;
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
