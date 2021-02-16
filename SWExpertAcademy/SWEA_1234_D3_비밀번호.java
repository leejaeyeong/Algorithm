package date0212;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1234_D3_비밀번호 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			List<Character> list = new LinkedList<>();
			for (char c : sc.next().toCharArray()) {
				list.add(c);
			}
			int index = 0;
			int passwardSize = list.size();
			while (true) {
				if (index + 1 < passwardSize) {
					if (list.get(index) == list.get(index+1)) {
						list.remove(index);
						list.remove(index);
						passwardSize = list.size();
						if (index != 0)	{
							index--;
							continue;
						}
					}
					else {
						index++;
					}
				}
				else {
					break;
				}
			}
			System.out.print("#" + t + " ");
			for (char c : list) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
