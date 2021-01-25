
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
		
		for (int i = y; i < N; i++) { // ����
			if (arr[i][x] != target)
				break;
			verticalCnt++;
		}
		for (int i = y - 1; i >= 0 ; i--) { // �Ʒ���
			if (arr[i][x] != target)
				break;
			verticalCnt++;
		}
		
		for (int i = x; i < N; i++) { // ������
			if (arr[y][i] != target)
				break;
			horizentalCnt++;
		}
		for (int i = x - 1; i >= 0; i--) { // ����
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
				maxCnt = Math.max(getMax(arr, i, j), maxCnt);  // �ʱ� ���¿��� �ִ� �� ���
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					
					if (ny < 0 || ny >= N || nx < 0 || nx >= N) // ���� üũ 
						continue;
					
					// ���� ��ġ ����
					char temp = arr[i][j];
					arr[i][j] = arr[ny][nx];
					arr[ny][nx] = temp;
					
					// ����� ������ �������� �ִ� �� ��� 
					maxCnt = Math.max(getMax(arr,ny,nx), maxCnt);
					maxCnt = Math.max(getMax(arr,i,j), maxCnt);
					
					// ���� ���·� ����
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