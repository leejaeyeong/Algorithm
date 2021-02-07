package Test;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_3499_D3_퍼펙트_셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			String[] deck = new String[N];
			
			for (int i = 0; i < N; i++) {
				deck[i] = sc.next();
			}
			
			int n = N / 2;
			if (N % 2 == 1) n++;
			
			String[] arr1 = new String[n];
			String[] arr2 = new String[N / 2];
			
//			System.out.println(Arrays.toString(arr1));
//			System.out.println(Arrays.toString(arr2));
			
			int arr1Index = 0;
			int arr2Index = 0;
			for (int i = 0; i < N; i++) {
				if (i < n) {
					arr1[arr1Index++] = deck[i];
					continue;
				}
				arr2[arr2Index++] = deck[i];
				
			}
			
			arr1Index = 0;
			arr2Index = 0;
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					System.out.print(arr1[arr1Index++] + " ");
					continue;
				}
				System.out.print(arr2[arr2Index++] + " ");
			}
			System.out.println();
		}
	}
}
/*
 * 
3
6
A B C D E F
4
JACK QUEEN KING ACE
5
ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA

 */
// 6 / 2 ==> 3 ==> 0, 1, [2] 작다k

// 5 / 2 ==> 2 ===> 0 , 1 작다

