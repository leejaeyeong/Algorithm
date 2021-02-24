package date0225;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859_D2_백만장자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = arr[N-1];
			int answer = 0;
			for (int i = N-1; i >= 0; i--) {
				if (arr[i] < max)
					answer += max - arr[i];
				else 
					max = arr[i];
			}
			System.out.println("#" + t + " " + answer);
		}
	}
}
