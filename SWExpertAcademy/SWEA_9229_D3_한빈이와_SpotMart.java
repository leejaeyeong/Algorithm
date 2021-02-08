package date0208;
import java.util.Scanner;

public class SWEA_9229_D3_한빈이와_SpotMart {
	static int[] arr;
	static int ret;
	static int[] num;
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N];
			num = new int[2];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			ret = -1;
			combi(0,0);
			System.out.println("#" + t + " " + ret);
		}
	}
	static void combi(int cnt, int index) {
		if (cnt == 2) {
			int weight = num[0] + num[1]; 
			if (weight > M) return;
			ret = Math.max(ret, weight);
			return;
		}
		for (int i = index; i < N; i++) {
			num[cnt] = arr[i];
			combi(cnt+1, i+1);
		}
	}
}
