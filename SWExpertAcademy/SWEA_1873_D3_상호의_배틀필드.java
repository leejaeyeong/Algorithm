package date0203;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1873_��ȣ��_��Ʋ�ʵ� {
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
			int dir; // 1��, 2��, 3��, 4��
			Tank(int y, int x, int dir) { // ������ ��ǥ
				this.y = y;
				this.x = x;
				this.dir = dir;
				//System.out.println("������ " + y +" " + x+ " " + dir);
			}
			
			void move(char command) {
				if (command == 'U') { // ���� �ٲٱ�
					map[y][x] = '^';
					this.dir = 1; // ��
				}
				else if (command == 'D') {
					map[y][x] = 'v';
					this.dir = 2; // ��
				}
				else if (command == 'L') {
					map[y][x] = '<';
					this.dir = 3; // ��
				}
				else if (command == 'R') {
					map[y][x] = '>';
					this.dir = 4; // ��
				}
				
				// �̵� �������� üũ
				if (isMove(y,x,dir)) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					map[ny][nx] = map[y][x]; // �̵�
					map[y][x] = '.'; // ������ �������
					
					this.y = ny; // ���� ��ǥ ����
					this.x = nx;
				}
			}
			void shot() {
				if (dir == 1) { // ��
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
				else if (dir == 2) { // ��
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
				else if (dir == 3) { // ��
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
				else if (dir == 4) { // ��
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
					if (map[i][j] == '^') { // �� 1
						tank = new Tank(i,j,1);
						break;
					}
					if (map[i][j] == 'v') { // �� 2
						tank = new Tank(i,j,2);
						break;
					}
					if (map[i][j] == '<') { // �� 3
						tank = new Tank(i,j,3);
						break;
					}
					if (map[i][j] == '>') { // �� 4
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
