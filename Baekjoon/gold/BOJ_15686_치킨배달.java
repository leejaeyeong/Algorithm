package date0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


class Location {
	int y;
	int x;
	Location(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class BOJ_15686_치킨배달 {
	static int N, M;
	static ArrayList<Location> homeList, chickenList;
	static Location[] selectedChicken;
	static ArrayList<Integer> chickenDistanceList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		homeList = new ArrayList<>();
		chickenList = new ArrayList<>();
		chickenDistanceList = new ArrayList<>(); // 도시의 치킨 거리 경우의 수
		selectedChicken = new Location[M]; // m를 개를 뽑은 치킨집 저장
		for (int i = 0; i < N; i++) { // 입력 받기 
			st =  new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) { //집
					homeList.add(new Location(i,j));
				} else if (num == 2) { // 치킨
					chickenList.add(new Location(i,j));
				}
			}
		}
		combination(0,0);
		chickenDistanceList.sort((o1, o2) -> o1-o2);
		System.out.println(chickenDistanceList.get(0));
		
	}
	static void combination(int cnt, int index) {
		if (cnt == M) {
			int chickenDistance = 0; // 치킨거리
			for (int j = 0; j < homeList.size(); j++) {
				int min = Integer.MAX_VALUE;
				Location home = homeList.get(j);
				for (int i = 0; i < M; i++) {
					Location chick = selectedChicken[i];
					int dist = Math.abs(chick.y - home.y) + Math.abs(chick.x - home.x);
					min = Math.min(min, dist);
				}
				chickenDistance += min;
			}
			chickenDistanceList.add(chickenDistance);
			return;
		}
		for (int i = index; i < chickenList.size(); i++) {
			selectedChicken[cnt] = chickenList.get(i);
			combination(cnt+1, i+1);
		}
	}
}
