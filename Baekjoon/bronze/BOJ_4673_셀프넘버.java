package date0323;

public class BOJ_4673_셀프넘버 {
	static int[] arr;
	public static void main(String[] args) {
		arr = new int[10001];
		for (int i = 1; i <= 10000; i++) {
			arr[i] = 0;
		}
		for (int i = 1; i <= 10000; i++) {
			d(i);
		}
		
		for (int i = 1; i <= 10000; i++) {
			if (arr[i] == 0)
				System.out.println(i);
		}
	}
	static void d(int n) {
		int temp = n;
		String s = Integer.toString(n);
		for (int i = 0; i < s.length(); i++) {
			temp += s.charAt(i) - '0' ;
		}
		if (temp >= 10001) 
			return;
		arr[temp] = 1;
		d(temp);
			
	}
}
