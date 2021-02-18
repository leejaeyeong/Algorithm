package date0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	static boolean[][] used;
	static int[] dy = {-1, 0, 1};
	static int r, c, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt((st.nextToken()));
		c = Integer.parseInt((st.nextToken()));
		used = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (line[j] == 'x') {
					used[i][j] = true;
				}
			}
		}
		for (int i = 0; i < r; i++) {
			if (search(i,0)) ans++;
		}
		System.out.println(ans);
	}
	static boolean search(int y, int x) {
		if (x == c-1) {
			return true;
		}
		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + 1;
			
			if (ny < 0 || ny >= r || used[ny][nx])
				continue;
			
			used[ny][nx] = true;
			if(search(ny,nx)) 
				return true;
			// used[ny][nx] = false // 실패한 흔적 되돌리지 않기 뒤에 상황은 현재보다 유리하지 않은 상황이고 이미 실패한 경로를 반복하게 됨
		}
		return false;
	}
}
