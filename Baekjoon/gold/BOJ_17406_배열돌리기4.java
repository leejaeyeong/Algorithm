package date0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4 {
	static int R, N, M, minValue;
	static boolean[] visited;
	static int[][] permuArr, rotates, origin, arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		visited = new boolean[R];
		minValue = Integer.MAX_VALUE;
		origin = new int[N][M];
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = origin[i][j];
			}
		}
		rotates = new int[R][3];
		permuArr = new int[R][3];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			rotates[i][0] = Integer.parseInt(st.nextToken()); // r
			rotates[i][1] = Integer.parseInt(st.nextToken()); // c
			rotates[i][2] = Integer.parseInt(st.nextToken()); // s
		}
		
		
		permutation(0);
		System.out.println(minValue);
	}
	static void print(int[][] temp) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(temp[i]));
		}
	}
	static int[][] rotate(int r, int c, int s, int[][] temp) {
		for (int i = 0; i < s; i++) { // 안쪽으로 몇 번 돌리는지
			int save = temp[r-s-1 + i][c-s-1+i]; // 저장
			int y = r -s + i -1  , x =  c - s + i -1;
			for (int j = 0; j < 2 * s - 2*i; j++) { // 아래에서 위로
				temp[y][x] = arr[++y][x];
			}
			for (int j = 0; j < 2 * s - 2*i; j++) { // 오른쪽에서 왼쪽
				temp[y][x] = arr[y][++x];
			}
			for (int j = 0; j < 2 * s - 2*i; j++) { // 위에서 아래
				temp[y][x] = arr[--y][x];
			}
			for (int j = 0; j < 2 * s - 2*i; j++) { // 왼쪽에서 오른족
				temp[y][x] = arr[y][--x];
			}
			temp[r-s-1 + i][c-s+i] = save; 
		}
		arr = temp;
		return temp;
		
	}
	static void permutation(int cnt) {
		if (cnt == R) {
			int[][] temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			for (int i = 0; i < R; i++) {
				temp = rotate(permuArr[i][0], permuArr[i][1], permuArr[i][2], temp);
			}
			int minColVal = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += temp[i][j];
					arr[i][j] = origin[i][j];
				}
				minColVal = Math.min(minColVal, sum);
			}
			minValue = Math.min(minColVal, minValue);
			return;
		}
		for (int i = 0; i < R; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			permuArr[cnt] = new int[] { rotates[i][0], rotates[i][1], rotates[i][2] };
			permutation(cnt+1);
			visited[i] = false;
			
		}
	}
}