package date0220;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_17413_단어뒤집기2 {
	static Stack<String> stack;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		
		// 띄어 쓰기는 똑같이 처리
		// 문자 묶음은 뒤집는다.
		// <> 안에 있는건 안뒤집음
		// 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] original = br.readLine().toCharArray();
		stack = new Stack<>();
		sb = new StringBuilder();
		
		boolean isOpen = false;
		for (int i = 0; i < original.length; i++) {
			// 일반적인 상황
			if (!isOpen) { 
				if (original[i] == ' ') {
					clearStack();
					sb.append(' ');
					continue;
				} else if (original[i] == '<') {
					clearStack();
					sb.append('<');
					isOpen = true;
					continue;
				}
				stack.push(Character.toString(original[i]));
			}
			else {
				sb.append(original[i]);
				if (original[i] == '>') {
					isOpen = false;
				} 
			}
		}
		
		clearStack();
		System.out.println(sb.toString());
		
	}
	static void clearStack() {
		if (!stack.isEmpty()) {
			int cnt = stack.size();
			for (int j = 0; j < cnt; j++) {
				sb.append(stack.pop());
			}
		}
	}
}
