package Algorithm0202;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SWEA_1288_D2_새로운_불면증_치료법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			set.clear();
			int N = sc.nextInt();
			
			int mult = 1;
			int temp = N;
			while (set.size() != 10) {
				int length = Integer.toString(temp).length();
				for (int i = 0; i < length; i++) {
					set.add(temp % 10);
					temp /= 10;
				}
				temp = N * (++mult);
				
			}
			System.out.println("#" + t + " " + N * --mult);
		}
	}
}
