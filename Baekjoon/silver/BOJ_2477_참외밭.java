package date0219;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<int[]> list1 = new ArrayList<>();
		ArrayList<int[]> list2 = new ArrayList<>();
		int[] arr = new int[6];
		
		for (int i = 0; i < 6; i++) {
			int dr = sc.nextInt();
			int length = sc.nextInt();
			
			if (dr == 1 || dr == 2) // 동서
				list1.add(new int[] {i, length});
			else  // 남북
				list2.add(new int[] {i, length});
			arr[i] = length;
		}
		list1.sort((o1,o2) -> o1[1] - o2[1]); 
		list2.sort((o1,o2) -> o1[1] - o2[1]);
		
		int bigGaro = list1.get(list1.size()-1)[1];
		int bigSero = list2.get(list2.size()-1)[1];
		int bigArea = bigGaro * bigSero; // 전체 넓이
		
		int seq1 = list1.get(list1.size()-1)[0];
		int seq2 = list2.get(list2.size()-1)[0];
		int emptyGaro = arr[(seq1+3)%6];
		int emptySero = arr[(seq2+3)%6];
		
		System.out.println((bigArea - emptyGaro * emptySero) * N);
	}
}
