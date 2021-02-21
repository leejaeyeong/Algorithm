package date0221;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2605_줄세우기 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		list.add(sc.nextInt()+1);
		for (int i = 1; i < N; i++) {
			int loc = sc.nextInt();
			list.add(list.size() - loc, i+1);
		}
		for (int i = 0; i < N; i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
