package date0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609_최대공약수와_최소공배수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = stoi(st.nextToken()), b = stoi(st.nextToken());
		int gcd = gcd(a, b);
		System.out.println(gcd);
		System.out.println(a * b / gcd);

	}
	private static int gcd(int a, int b) {
		if(b == 0) return a;
        else return gcd(b, a % b);
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
