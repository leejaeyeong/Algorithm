package Test;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1223_D4_계산기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			StringBuilder sb = new StringBuilder();
			Stack<Character> st = new Stack<>();
			
			int N = sc.nextInt();
			char[] arr = sc.next().toCharArray();
			
			for (int i = 0; i < N; i++) {
				if (arr[i] == '*' || arr[i] == '+') {
					if (st.isEmpty()) {
						st.push(arr[i]);
						continue;
					}
					else {
						if (st.peek() == '+') {
							st.push(arr[i]); // 마지막이 우선 순위가 낮으면 무조건 넣음
							continue;
						}
						sb.append(st.pop());
						st.push(arr[i]);
					}
				}
				else {
					sb.append(arr[i]);
				}
			}
			
			while (!st.isEmpty()) {
				sb.append(st.pop());
			}
			
			String s = sb.toString();
			arr = s.toCharArray();
			
			Stack<String> st2 = new Stack<>();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != '*' && arr[i] != '+') {
					st2.push(Character.toString(arr[i]));
				}
				else {
					if (arr[i] == '*') {
						int a = Integer.parseInt(st2.pop());
						int b = Integer.parseInt(st2.pop());
						st2.push(Integer.toString(b * a));
					}
					else {
						int a = Integer.parseInt(st2.pop());
						int b = Integer.parseInt(st2.pop());
						st2.push(Integer.toString(b + a));
					}
				}
			}
			System.out.println("#" + t + " " + st2.pop());
			
			
		}
	}
}
