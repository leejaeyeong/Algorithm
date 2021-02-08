package date0208;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1860_D3_진기의_최고급_붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 사람
			int M = sc.nextInt(); // 초
			int K = sc.nextInt(); // 개수
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			int remainCnt = 0;
			int time = 0;
			boolean isPossible = true;
			for (int i = 0; i < N; i++) {
				if (remainCnt <= 0) {
					time += M;
					remainCnt += K;					
				}
				if (arr[i] < time) { // 손님이 더 빨리옴
					isPossible = false;
					break;
				}
				--remainCnt;
			}
			System.out.print("#" + t + " ");
			System.out.println(!isPossible ? "Impossible" : "Possible");
		}
	}
}
