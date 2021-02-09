package date0209;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1233_D4_사칙연산_유효성검사 {
	static boolean isSuccess;
	static int N;
	static char[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			isSuccess = true;
			N = sc.nextInt();
			sc.nextLine();
			arr = new char[N+1];
			
			for (int i = 1; i <= N; i++) {
                String[] info = sc.nextLine().split(" ");
                System.out.println(Arrays.toString(info));
                arr[i] = info[1].charAt(0);
			}
			System.out.print("#" + t + " ");
			boolean state = false;
			for (int i = 1; i <= N; i++) {
				if (2 * i > N) { // 리프노드이면
					if (!Character.isDigit(arr[i])) {
						System.out.println(0);
						state = true;
						break;
					}
				}
				else if (Character.isDigit(arr[i])) {
					System.out.println(0);
					state = true;
					break;
				}
			}
			if (!state)
				System.out.println(1);
			
		}
	}
}
