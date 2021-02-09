package date0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	static int[][] box;
	static boolean[][] visited;
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static int r;
	static int c;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        int tomatoCnt = 0; // 안익은 토마토 개수
		box = new int[r][c];
		visited = new boolean[r][c];
		Queue<int[]> que = new LinkedList<>();
		for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
					que.offer(new int[] {i, j}); // 익은 토마토 좌표
					visited[i][j] = true;
				} else if (box[i][j] == 0) {
					tomatoCnt++;
				}
            }
        }
		if (tomatoCnt == 0) {
			System.out.println(0);
			return;
		}
		
		que.offer(new int[] {-1, -1}); // 날짜구분을 위한 기준
		
		int day = 0;
		while(!que.isEmpty()) {
			int y = que.peek()[0], x = que.poll()[1];
			if (y == -1 && x == -1) {
				day++; // 하루 지남
				if (tomatoCnt == 0)
					break;
				if (!que.isEmpty())
					que.offer(new int[] {-1, -1});
				continue;
			}
			
			
			for (int i = 0 ; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny >= r || ny < 0 || nx >= c || nx < 0) 
					continue;
				if (visited[ny][nx] || box[ny][nx] == -1)
					continue;
				
				tomatoCnt--;
				box[ny][nx] = 1;
				visited[ny][nx] = true;
				que.offer(new int[] {ny, nx});
				
			}
		}
		System.out.println(tomatoCnt != 0 ? -1 : day);

		
	}
}
