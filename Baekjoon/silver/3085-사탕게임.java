
import java.util.Scanner;

public class Main {
	int N;
	int[] dy = {0, 0, 1, -1};
	int[] dx = {1, -1, 0, 0};
	Scanner sc = new Scanner(System.in);
	
	public int getMax(char[][] arr, int y, int x) {
		int verticalCnt = 0;
		int horizentalCnt = 0;
		char target = arr[y][x];
		
		for (int i = y; i < N; i++) { // 위쪽
			if (arr[i][x] != target)
				break;
			verticalCnt++;
		}
		for (int i = y - 1; i >= 0 ; i--) { // 아래쪽
			if (arr[i][x] != target)
				break;
			verticalCnt++;
		}
		
		for (int i = x; i < N; i++) { // 오른쪽
			if (arr[y][i] != target)
				break;
			horizentalCnt++;
		}
		for (int i = x - 1; i >= 0; i--) { // 왼쪽
			if (arr[y][i] != target)
				break;
			horizentalCnt++;
		}
			
		return Math.max(verticalCnt, horizentalCnt);
	}
	public void execute() {
		
		N = sc.nextInt();
		char[][] arr = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next().toCharArray();
		}
		
		int maxCnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maxCnt = Math.max(getMax(arr, i, j), maxCnt);  // 초기 상태에서 최대 수 계싼
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					
					if (ny < 0 || ny >= N || nx < 0 || nx >= N) // 범위 체크 
						continue;
					
					// 사탕 위치 변경
					char temp = arr[i][j];
					arr[i][j] = arr[ny][nx];
					arr[ny][nx] = temp;
					
					// 변경된 지점을 기준으로 최대 수 계산 
					maxCnt = Math.max(getMax(arr,ny,nx), maxCnt);
					maxCnt = Math.max(getMax(arr,i,j), maxCnt);
					
					// 원래 형태로 복원
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