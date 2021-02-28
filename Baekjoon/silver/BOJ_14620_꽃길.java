package date0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Cost {
	int[] dy = { 1, -1, 0, 0, 0};
	int[] dx = { 0, 0, -1, 1, 0};
	int cost;
	int[][] locations = new int[5][2];
	Cost(int[][] map, int y, int x) {
		for (int i = 0; i < 5; i++) {
			cost += map[y+dy[i]][x+dx[i]];
			locations[i] = new int[] {y + dy[i], x + dx[i]};
		}
	}
	public int getCost() {
		return cost;
	}
	public int[][] getLocation() {
		return locations;
	}
}
public class BOJ_14620_꽃길 {
	static int N, minCost = Integer.MAX_VALUE;
	static ArrayList<Cost> costs;
	static Cost[] selectedLocation = new Cost[3];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		StringTokenizer st;
		costs = new ArrayList<>(); 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= N-2; i++) { // 비용 저장
			for (int j = 1; j <= N-2; j++) {
				costs.add(new Cost(map,i,j));
			}
		}
		
		combination(0,0);
		System.out.println(minCost);
	} // end of main
	private static void combination(int cnt, int index) {
		if (cnt == 3) {
			int[][][] candidate = new int[3][5][2];
			for (int i = 0; i < 3; i++) {
				candidate[i] = selectedLocation[i].getLocation();
			}
			
			for (int i = 0; i < 3-1; i++) {
				for (int j = i+1; j < 3; j++) {
					for (int k = 0; k < 5; k++) {
						for (int l = 0; l < 5; l++) {
							if (candidate[i][k][0] == candidate[j][l][0] && candidate[i][k][1] == candidate[j][l][1])
								return;
						}
					}
				}
			}
			
//			int[][] location1 = selectedLocation[0].getLocation();
//			int[][] location2 = selectedLocation[1].getLocation();
//			int[][] location3 = selectedLocation[2].getLocation();
//			for (int i = 0; i < 5; i++) { // 첫 번째 꽃과 두 번째 꽃 위치 확인
//				for (int j = 0; j < 5; j++) {
//					if (location1[i][0] == location2[j][0] && location1[i][1] == location2[j][1])
//						return;
//				}
//			}
//			for (int i = 0; i < 5; i++) {
//				for (int j = 0; j < 5; j++) {
//					if (location1[i][0] == location3[j][0] && location1[i][1] == location3[j][1])
//						return;
//				}
//			}
//			for (int i = 0; i < 5; i++) {
//				for (int j = 0; j < 5; j++) {
//					if (location2[i][0] == location3[j][0] && location2[i][1] == location3[j][1])
//						return;
//				}
//			}
			int costSum = 0;
			for (int i = 0 ; i < 3; i++) {
				costSum += selectedLocation[i].getCost();
			}
			minCost = Math.min(minCost, costSum);
			return;
		}
		for (int i = index; i < costs.size(); i++) {
			selectedLocation[cnt] = costs.get(i);
			combination(cnt + 1, i + 1);
		}
	}
} // end of class
