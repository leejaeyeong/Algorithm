package date0705;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5430_AC {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = stoi(st.nextToken());
		
		for (int t = 0; t < T; t++) {
			String cmd = br.readLine();
			int n = stoi(br.readLine());
			String[] arr = br.readLine().replace('[',',').replace(']', ',').split(",");
			int front = 1, back = n + 1;
			boolean isErr = false, isForward = true ;
			for (int i = 0; i < cmd.length(); i++) {
				char act = cmd.charAt(i);
				if (act == 'R') {
					isForward = !isForward;
				} else { // D
					if (isForward && ++front > back
							|| !isForward && --back < front) {
						isErr = true;
						break;
					}
				}
			}
			if (isErr) System.out.println("error");
			else print(front, back, arr, isForward);
			
		}

	}
	private static void print(int front, int back, String[] arr, boolean isForward) {
		StringBuilder sb = new StringBuilder();
		if (isForward) {
			for (int i = front; i < back; i++) {
				sb.append(arr[i]);
				if (i != back - 1) {
					sb.append(",");
				}
			}
		} else {
			for (int i = back - 1; i >= front; i--) {
				sb.append(arr[i]);
				if (i != front) {
					sb.append(",");
				}
			}
		}
		System.out.println("[" + sb.toString() + "]");
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
