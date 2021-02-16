package date0216;

import java.util.Arrays;
import java.util.Scanner;

public class 정올_냉장고 {
	static class Chemical implements Comparable<Chemical>{
		int minTemp;
		int maxTemp;
		public Chemical(int min, int max) {
			this.minTemp = min;
			this.maxTemp = max;
		}
		@Override
		public int compareTo(Chemical c) {
			return maxTemp - c.maxTemp;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Chemical[] arr = new Chemical[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new Chemical(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(arr);
		int prev = arr[0].maxTemp;
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i].minTemp > prev) {
				cnt++;
				prev = arr[i].maxTemp;
			}
		}
		System.out.println(cnt);
	}
}
