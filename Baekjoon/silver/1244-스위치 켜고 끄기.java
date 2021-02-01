package AlgorithmHW01;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int numOfStudent = sc.nextInt();
		for (int i = 0; i < numOfStudent; i++) {
			int gender = sc.nextInt();
			int index = sc.nextInt();
			
			if (gender == 1) { // 남자인 경우
				for (int j = index; j <= N; j += index) {
					arr[j] = (arr[j] == 0) ? 1 : 0;
				}
			}
			else { // 여자 남자인 경우
				int pointer = 1;
				while (true) {
					int left = index - pointer;
					int right = index + pointer;
					
					if (left < 1 || right >= arr.length) {
						break;
					}
					if (arr[left] == arr[right]) {
						pointer++;
						continue;
					}
					break;
				}
				
				arr[index] = arr[index] == 1 ? 0 : 1;
				for (int j = 1; j < pointer; j++) {
					arr[index-j] = arr[index-j] == 1 ? 0 : 1;
					arr[index+j] = arr[index+j] == 1 ? 0 : 1;
				}
			}
		}
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) 
				System.out.println();
		}
	}
}
