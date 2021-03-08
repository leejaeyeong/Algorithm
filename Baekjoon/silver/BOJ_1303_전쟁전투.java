package date0309;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1303_전쟁전투 {
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int r,c;
	static char[][] arr;
	static ArrayList<Integer> wList, bList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		wList = new ArrayList<>();
		bList = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] != '0') {
					char team = arr[i][j];
					arr[i][j] = '0';
					if (team == 'W') {
						wList.add(solve(i,j, 1, team));
					} else {
						bList.add(solve(i,j, 1, team));
					}
					
				}
			}
		}
		int wSum = 0, bSum = 0;
		for (int i = 0; i < wList.size(); i++) {
			wSum += wList.get(i) * wList.get(i);
		}
		for (int i = 0; i < bList.size(); i++) {
			bSum += bList.get(i) * bList.get(i);
		}
		System.out.println(wSum + " " + bSum);
	}
	static int solve(int y, int x, int cnt, char team) {
		int max = cnt;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= r || nx < 0 || nx >= c || team != arr[ny][nx] || arr[ny][nx] == '0') 
				continue;
			arr[ny][nx] = '0';
			if (max > cnt) {
				cnt = max;
			}
			max = Math.max(solve(ny,nx, cnt+1, team),  max);
		}	
		return max;
	}
}
