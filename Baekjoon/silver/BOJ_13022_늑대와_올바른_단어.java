package date0427;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_13022_늑대와_올바른_단어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		System.out.println(answer(text.toCharArray()));
	}

	private static int answer(char[] text) {
		int[] count = new int[4];
		for (char ch : text) {
			if (ch == 'w') count[0]++;
			else if (ch == 'o') count[1]++;
			else if (ch == 'l') count[2]++;
			else if (ch == 'f') count[3]++;
		}
		
		if (count[0] != count[1] 
			|| count[0] != count[2] 
			|| count[0] != count[3]) // w, o, l, f 개수가 다르면 
			return 0;
		
		count = new int[4];
		int prevIndex = 0;
		for (char ch : text) {
			switch(ch) {
			case 'w':
				++count[0];
				if (count[2] != count[3] // f -> w로 이어지는 경우 l과 f의 개수가 다르면
						|| prevIndex != 3 && prevIndex != 0) // 이전 인덱스의 위치가 o, l인 경우 
					return 0;
				prevIndex = 0;
				break;
			case 'o':
				if (prevIndex > 1) return 0; // 이전 인덱스가 더 뒤쪽
				if (++count[1] > count[0]) return 0; // 이전 문자 보다 더 많이나옴
				prevIndex = 1;
				break;
			case 'l':
				if (prevIndex > 2) return 0; // 이전 인덱스가 더 뒤쪽
				if (count[0] != count[1]) return 0; // 앞쪽 문자가 완성되지 않음 
				if (++count[2] > count[1]) return 0; // 이전 문자 보다 더 많이나옴
				prevIndex = 2;
				break;
			case 'f':
				if (count[1] != count[2]) return 0; // 앞쪽 문자가 완성되지 않음 
				if (++count[3] > count[2]) return 0; // 이전 문자 보다 더 많이나옴
				prevIndex = 3;
				break;
			}
		}
		return 1;
	}
}
