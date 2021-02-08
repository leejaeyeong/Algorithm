package date0208;

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_1228_D3_암호문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<Integer>();

			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			int commandCnt = sc.nextInt();
			for(int i = 0; i < commandCnt; i++) {
				String in = sc.next(); //"I"
				int index = sc.nextInt(); 
				int num  = sc.nextInt();
				for(int j = 0; j <num ; j++) {
					list.add(index++, sc.nextInt());
				}
			}
			System.out.println("#" + t);
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();

		}
	}
}
