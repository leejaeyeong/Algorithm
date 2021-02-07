package date0204;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_D4_괄호짝짓기 {
	static char[] start = { '(', '[', '{', '<' };
	static char[] end = { ')', ']', '}', '>' };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> st = new Stack<>();
		
		for (int t = 1; t <= 10; t++) {
			int length = sc.nextInt();
			char[] arr = new char[length];
			arr = sc.next().toCharArray();
			
			boolean flag = true;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{' || arr[i] == '<') {
					st.push(arr[i]);
					continue;
				}
				for (int j = 0; j < 4; j++) {
					if (arr[i] == end[j]) {
						if (st.isEmpty() || st.peek() != start[j]) {
							flag = false;
							break;
						}
					}
				}
				st.pop();
			}
			st.clear();
			System.out.print("#" + t + " ");
			System.out.println(flag && st.size() == 0 ? 1 : 0);
			
		}
	}
	
}
