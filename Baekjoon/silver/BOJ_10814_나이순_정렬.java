package date0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10814_나이순_정렬 {
	static class User {
		int age;
		String name;
		User(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public String toString() {
			return age + " " + name;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = stoi(br.readLine());
		List<User> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int age = stoi(st.nextToken());
			String name = st.nextToken();
			list.add(new User(age, name));
		}
		
		list.sort((u1, u2) -> {
			return u1.age - u2.age;
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(list.get(i) + "\n");
		}
		System.out.println(sb.toString());

	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
