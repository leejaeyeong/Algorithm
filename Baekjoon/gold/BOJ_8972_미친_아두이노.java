package date0330;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_8972_미친_아두이노 {
	static class Aduino {
		int y,x,cnt;
		Aduino(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
		int compareDistance(int y, int x) {
			return Math.abs(this.y - y) + Math.abs(this.x - x);
		}
		@Override 
		public boolean equals(Object o) {
			Aduino adu = (Aduino)o;
			return this.y == adu.y && this.x == adu.x;
		}
		@Override
		public int hashCode() {
			return Integer.toString(y * x).hashCode();
		}
		
	}
	static Aduino aduino;
	static int r,c;
	static Queue<Aduino> crazyAduinoQue;
	static int[] dy = {Integer.MAX_VALUE,  1, 1, 1, 0, 0, 0, -1, -1, -1};
	static int[] dx = {Integer.MAX_VALUE, -1, 0, 1,-1, 0, 1, -1,  0, 1};
	static int[][] stateMap;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = stoi(st.nextToken());
		c = stoi(st.nextToken());
		map = new char[r][c]; 
		stateMap = new int[r][c];
		crazyAduinoQue = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'R') {
					crazyAduinoQue.offer(new Aduino(i,j,0));
				} else if (map[i][j] == 'I') {
					aduino = new Aduino(i,j,0);
				}
			}
		}
		String move = br.readLine();
		if (!game(move)) {
			System.out.println("kraj " + aduino.cnt);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
			
	}
	private static boolean game(String move) {
		ArrayList<int[]> fillList = new ArrayList<>();
		Set<Aduino> deleteSet = new HashSet<>();
		for (int i = 0; i < move.length(); i++) {
			
			int dir = move.charAt(i) - '0';
			// 종수 아두이노 이동
			map[aduino.y][aduino.x] = '.';
			aduino.y += dy[dir]; 
			aduino.x += dx[dir];
			aduino.cnt += 1;
			if (map[aduino.y][aduino.x] == 'R') {
				return false;
			}
			map[aduino.y][aduino.x] = 'I';
			
			// 미친 아두이노 이동
			while(!crazyAduinoQue.isEmpty()) {
				int size = crazyAduinoQue.size();
				for (int j = 0; j < size; j++) {
					Aduino crazyAdu = crazyAduinoQue.poll();
					int minDist = Integer.MAX_VALUE;
					int dr = 0;
					for (int k = 1; k <= 9; k++) {
						if (k == 5) continue;
						int ny = crazyAdu.y + dy[k];
						int nx = crazyAdu.x + dx[k];
						if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
						
						if (minDist > aduino.compareDistance(ny, nx)) {
							minDist = aduino.compareDistance(ny, nx);
							dr = k;
						}
					}
					
					map[crazyAdu.y][crazyAdu.x] = '.'; // 이동 전 좌표 지우기
					crazyAdu.y += dy[dr];
					crazyAdu.x += dx[dr];
					stateMap[crazyAdu.y][crazyAdu.x] += 1; // 상태맵에 개수 증가
					if (stateMap[crazyAdu.y][crazyAdu.x] >= 2) {
						deleteSet.add(crazyAdu);
						continue; // 큐에 다시 넣지 않음
					}
					if (map[crazyAdu.y][crazyAdu.x] == 'I') {
						return false;
					}
					fillList.add(new int[] {crazyAdu.y, crazyAdu.x}); // 이동 후 좌표 저장
					crazyAduinoQue.offer(crazyAdu);
				}	
				
				for (int j = 0 ; j < fillList.size(); j++) {
					int y = fillList.get(j)[0];
					int x = fillList.get(j)[1];
					map[y][x] = 'R';
				}
				
				for (Aduino adu : deleteSet) {
					if (crazyAduinoQue.contains(adu)) {
						map[adu.y][adu.x] = '.'; 
						crazyAduinoQue.remove(adu);
					}
				}
				
				clearStateMap();
				fillList.clear();
				deleteSet.clear();
				break;
			}
		}
		return true;
	}
	private static void clearStateMap() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				stateMap[i][j] = 0;
			}
		}
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
