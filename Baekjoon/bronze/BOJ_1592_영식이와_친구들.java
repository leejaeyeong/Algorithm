package date0220;

import java.util.Scanner;

public class BOJ_1592_영식이와_친구들 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt(); // L번째
		
		int[] people = new int[N];
		int throwCount = 0; // 공을 던지는 횟수
		int ballLocation = 0;  // 공의 위치 
		while (true) {
			people[ballLocation]++; // 공 받으면 증가
			if (people[ballLocation] == M) {
				System.out.println(throwCount);
				break;
			}
			if (people[ballLocation] % 2 == 1) {
				// 시계 방향
				ballLocation = (ballLocation + L) % N; 
			}
			else {
				// 반시계 방향
				ballLocation = ballLocation - L;
				if (ballLocation < 0) 
					ballLocation += N;
			}
			throwCount++;
		}
	}
}
