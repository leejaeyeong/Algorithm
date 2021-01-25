
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	int N;
	public int getMax(char[][] arr, int y, int x) {
		int verticalCnt = 0;
		int horizentalCnt = 0;
		char target = arr[y][x];
		
		for (int i = y + 1; i < N; i++) { // 위쪽
			if (arr[i][x] != target)
				break;
			horizentalCnt++;
		}
		for (int i = y - 1; i >= 0 ; i--) { // 위쪽
			if (arr[i][x] != target)
				break;
			horizentalCnt++;
		}
		
		for (int i = x + 1; i < N; i++) {
			if (arr[y][i] != target)
				break;
			verticalCnt++;
		}
		for (int i = x - 1; i >= 0; i--) {
			if (arr[y][i] != target)
				break;
			verticalCnt++;
		}
			
		return Math.max(verticalCnt, horizentalCnt) + 1;
	}
	public void execute() {
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		char[][] arr = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next().toCharArray();
		}
		
		int maxCnt = 0; // 현재 상태에서 최대 구함
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maxCnt = Math.max(getMax(arr, i, j), maxCnt); 
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					
					if (ny < 0 || ny >= N || nx < 0 || nx >= N) 
						continue;
					
					char temp = arr[i][j];
					arr[i][j] = arr[ny][nx];
					arr[ny][nx] = temp;
					maxCnt = Math.max(getMax(arr,ny,nx), maxCnt);
					maxCnt = Math.max(getMax(arr,i,j), maxCnt);
					
					arr[ny][nx] = arr[i][j];
					arr[i][j] = temp;
					
				}
			}
		}
		System.out.println(maxCnt);
	}
	public static void main(String[] args) {
		new Main().execute();
	}
}

