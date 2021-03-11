package date0311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Student {
	int y;
	int x;
	String type;
	Student(int y, int x, String type) {
		this.y = y;
		this.x = x;
		this.type = type;
	}
}
public class BOJ_1941_소문난칠공주 {
	static char [][] arr;
	static int answer = 0;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static Student[] students;
	static Student[] candidate;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[5][5];
		students = new Student[25];
		candidate = new Student[7];
		for (int i = 0; i < 5; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				students[i*5 + j] = new Student(i,j,Character.toString(arr[i][j])); 
			}
		}
		combi(0,0,0,0);
		System.out.println(answer);
	}
	static void combi(int cnt, int index, int dasom, int doyean) {
		if (cnt == 7) {
			if (dasom < 4) return;
			if (bfs() != 7) return;
			answer++;
			return;
		}
		if (doyean >= 4) return;
		
		for (int i = index; i < 25; i++) {
			candidate[cnt] = students[i];
			if (students[i].type.equals("S"))
				combi(cnt+1, i+1, dasom+1, doyean);
			else {
				combi(cnt+1, i+1, dasom, doyean+1);
			}
		}
	}
	static int bfs() {
		boolean[] visited = new boolean[7];
		Queue<int[]> que = new LinkedList<>();
		int index = 0;
		visited[index] = true;
		que.offer(new int[] {index, candidate[index].y, candidate[index++].x});
		int cnt = 0;
		while(!que.isEmpty()) {
			cnt++;
			int currIndex = que.peek()[0];
			int y = que.peek()[1];
			int x = que.poll()[2];
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < 0 || ny >= 5 || nx< 0 || nx >= 5 ) continue;
				
				for (int j = 0; j < 7; j++) {
					if (currIndex == j) continue;
					if (visited[j]) continue;
					if (ny == candidate[j].y && nx == candidate[j].x) {
						visited[j] = true;
						que.offer(new int[] {j,ny,nx});
					}
				}
			}
		}
		return cnt;
	}
}
