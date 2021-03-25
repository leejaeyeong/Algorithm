package date0325;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3307_D3_최장증가_부분수열2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			int n = stoi(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			int[] lis = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = stoi(st.nextToken());
			}
			for (int i = 0; i < n; i++) {
				lis[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
						lis[i] = lis[j] + 1;
				}
			}
			Arrays.sort(lis);
			System.out.println("#" + t + " " + lis[n-1]);
		}

	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
