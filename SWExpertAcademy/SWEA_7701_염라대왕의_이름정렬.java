package date0319;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SWEA_7701_염라대왕의_이름정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		Set<String> nameSet;
		nameSet = new HashSet<>();
		for (int t = 1; t <= T; t++) {
			nameSet = new HashSet<>();
			int N = stoi(br.readLine());
			for (int i = 0; i < N; i++) { // 중복 제거
				nameSet.add(br.readLine());
			}
			String[] nameList = new String[nameSet.size()];
			Iterator ite = nameSet.iterator();
			int index = 0;
			while(ite.hasNext()) {
				nameList[index++] = (String)ite.next(); 
			}
			Arrays.sort(nameList, (s1, s2) -> {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				return s1.length() - s2.length();
			});
			System.out.println("#" + t);
			for (int i = 0; i < nameList.length; i++) {
				System.out.println(nameList[i]);
			}
		}
	}
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
