package date0317;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
	static int N, minDiffer;
	static int[][] map;
	static int[] startTeam;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		map = new int[N][N];
		startTeam = new int[N / 2];
		minDiffer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combi(0,0);
		System.out.println(minDiffer);
	}
	static void combi(int cnt, int index) {
		if (cnt == N / 2) {
			int[] linkTeam = new int[N / 2];
			int index1 = 0;
			int startTeamScore = 0;
			int linkTeamScore = 0;
			con : for (int i = 1; i <= N; i++) {
				for (int j = 0; j < N / 2; j++) {
					if (startTeam[j] == i) {
						continue con;
					}
				}
				linkTeam[index1++] = i;
			}
			
			for (int i = 0; i < N / 2 -1; i++) {
				for (int j = i + 1; j < N /2; j++) {
					startTeamScore += map[startTeam[i]-1][startTeam[j]-1];
					startTeamScore += map[startTeam[j]-1][startTeam[i]-1];
				}
			}
			for (int i = 0; i < N / 2 - 1; i++) {
				for (int j = i + 1; j < N /2; j++) {
					linkTeamScore += map[linkTeam[i]-1][linkTeam[j]-1];
					linkTeamScore += map[linkTeam[j]-1][linkTeam[i]-1];
				}
			}
			minDiffer = Math.min(minDiffer, Math.abs(startTeamScore - linkTeamScore));
			return;
		}
		for (int i = index; i < N ; i++) {
			startTeam[cnt] = i + 1;
			combi(cnt+1 , i + 1);
		}
	}
}
