package date0203;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1873_상호의_배틀필드 {
	static int H, W;
	static char[][] map;
	static char[] commands;
	static int[] dy = {0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, -1, 1};
	
	static boolean isMove(int y, int x, int dir) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (ny < 0 || ny >= H || nx < 0 || nx >= W)
			return false;
		return map[ny][nx] == '.' ? true : false;
	}
	public static void main(String[] args) {
		class Tank {
			int y;
			int x;
			int dir; // 1상, 2하, 3좌, 4우
			Tank(int y, int x, int dir) { // 전차의 좌표
				this.y = y;
				this.x = x;
				this.dir = dir;
				//System.out.println("생성자 " + y +" " + x+ " " + dir);
			}
			
			void move(char command) {
				if (command == 'U') { // 방향 바꾸기
					map[y][x] = '^';
					this.dir = 1; // 상
				}
				else if (command == 'D') {
					map[y][x] = 'v';
					this.dir = 2; // 하
				}
				else if (command == 'L') {
					map[y][x] = '<';
					this.dir = 3; // 좌
				}
				else if (command == 'R') {
					map[y][x] = '>';
					this.dir = 4; // 우
				}
				
				// 이동 가능한지 체크
				if (isMove(y,x,dir)) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					map[ny][nx] = map[y][x]; // 이동
					map[y][x] = '.'; // 평지로 만들어줌
					
					this.y = ny; // 전차 좌표 갱신
					this.x = nx;
				}
			}
			void shot() {
				if (dir == 1) { // 상
					for (int i = y - 1; i >= 0; i--) {
						if (map[i][x] == '*') {
							map[i][x] = '.';
							break;
						}
						else if (map[i][x] == '#') {
							break;
						}
					}
				}
				else if (dir == 2) { // 하
					for (int i = y + 1; i < H; i++) {
						if (map[i][x] == '*') {
							map[i][x] = '.';
							break;
						}
						else if (map[i][x] == '#') {
							break;
						}
					}
				}
				else if (dir == 3) { // 좌
					for (int i = x - 1; i >= 0; i--) {
						if (map[y][i] == '*') {
							map[y][i] = '.';
							break;
						}
						else if (map[y][i] == '#') {
							break;
						}
					}
				}
				else if (dir == 4) { // 우
					for (int i = x + 1; i < W; i++) {
						if (map[y][i] == '*') {
							map[y][i] = '.';
							break;
						}
						else if (map[y][i] == '#') {
							break;
						}
					}
				}
			}
			
		}
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];
			Tank tank = null;
			for (int i = 0; i < H; i++) {
				map[i] = sc.next().toCharArray();
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == '^') { // 상 1
						tank = new Tank(i,j,1);
						break;
					}
					if (map[i][j] == 'v') { // 하 2
						tank = new Tank(i,j,2);
						break;
					}
					if (map[i][j] == '<') { // 좌 3
						tank = new Tank(i,j,3);
						break;
					}
					if (map[i][j] == '>') { // 우 4
						tank = new Tank(i,j,4);
						break;
					}
				}
			}
//			for (int i = 0; i < map.length; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			sc.nextInt();
			commands = sc.next().toCharArray();
			
			for (char command : commands) {
				//System.out.println(command);
				if (command == 'S') {
					tank.shot();
				}
				else {
					tank.move(command);
				}
			}
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
		}
	}
}
