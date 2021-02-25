package date0226;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이 {
	static int[] arr, selected, save;
	static int answerCnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		selected = new int[7];
		save = new int[7];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		combination(0,0);
		for (int i = 0; i < 7; i++)
			System.out.println(save[i]);
		
	}
	private static void combination(int cnt, int index) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++)
				sum += selected[i];
			
			if (sum == 100) {
				answerCnt++;
				for (int i = 0; i < 7; i++)
					save[i] = selected[i];
			}
			return;
		}
		for (int i = index; i < 9; i++ ) {
			selected[cnt] = arr[i];
			combination(cnt+1, i+1);
		}
	}
	
}
