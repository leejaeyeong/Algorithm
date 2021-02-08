package date0207;

import java.util.Scanner;

public class SWEA_1940_D2_가랏RC카 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		for (int t = 1; t <= 10; t++) {
			int cnt = sc.nextInt(); 
			int s = 0;
			int v = 0;
			
			for (int i = 0; i < cnt; i++) {
				int option = sc.nextInt();
				if (option == 0) {
					s += v; // 현재 속도 유지
					continue;
				}
				int val = sc.nextInt();
				
				if (option == 1) {
					v += val;
					s += v;
					continue;
				}
				if (option == 2) {
					int temp = val >= v  ? 0 : v - val ;
					v = temp;
					s += v;
					continue; 
				}
			}

			System.out.println("#" + t + " " + s);
		}
	}
}
