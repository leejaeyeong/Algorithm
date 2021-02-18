package date0218;

import java.util.LinkedList;
import java.util.Scanner;


public class SWEA_1247_D5_최적경로 {
	static LinkedList<Location> list;
	static int currentY, currentX, goalY, goalX, ans, N;
	static boolean[] visited;
	static Location[] locationList;
	static class Location {
		int y;
		int x;
		Location(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			currentY = sc.nextInt();
			currentX = sc.nextInt();
			goalY = sc.nextInt();
			goalX = sc.nextInt();
			ans = Integer.MAX_VALUE;
			list = new LinkedList<>();
			visited = new boolean[N];
			locationList = new Location[N];
			for (int i = 0; i < N; i++ ) {
				list.add(new Location(sc.nextInt(), sc.nextInt()));
			}
			perm(0);
			System.out.println("#" + t + " " + ans);
		}
	}
	static void perm(int cnt) {
		if (cnt == N) {
			int distSum = Math.abs(currentY-locationList[0].y) + Math.abs(currentX-locationList[0].x);
			for (int i = 0; i < N-1; i++) {
				Location l1 = locationList[i];
				Location l2 = locationList[i+1];
				distSum += Math.abs(l1.y-l2.y) + Math.abs(l1.x-l2.x); 
			}
			distSum += Math.abs(goalY-locationList[N-1].y) + Math.abs(goalX-locationList[N-1].x);
			ans = Math.min(ans,  distSum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			locationList[cnt] = list.get(i);
			perm(cnt+1);
			visited[i] = false;
		}
	}
}
