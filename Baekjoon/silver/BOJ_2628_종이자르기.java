package date0217;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2628_종이자르기 {
	static class Paper {
		int[] start;
		int[] end;
		int area;
		Paper(int[] start, int[] end) {
			this.start = new int[] {start[0], start[1]};
			this.end = new int[] {end[0], end[1]};
		}
		void 넓이계산하기() {
			area = Math.abs(start[0]-end[0]) * Math.abs(start[1]-end[1]);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int r = sc.nextInt();
		int n = sc.nextInt();
		LinkedList<Paper> paperList = new LinkedList<>();
		paperList.add(new Paper(new int[] {0,0}, new int[] {r,c}));
		
		for (int i = 0 ; i < n; i++) {
			int dir = sc.nextInt(); // 방향
			int p = sc.nextInt(); // 자르는 위치
			
			ArrayList<Paper> deleteIndexList = new ArrayList<>();
			int paperSize = paperList.size();
			for (int j = 0; j < paperSize; j++) {
				Paper paper = paperList.get(j);
				if (p <= paper.start[dir] || p >= paper.end[dir]) { // 자르는 의미가 없으면 넘어감
					continue;
				}
				// 잘라서 추가해줌
				if (dir == 0) {
					paperList.add(new Paper(new int[] {paper.start[0], paper.start[1]}, new int[] {p, paper.end[1]}));
					paperList.add(new Paper(new int[] {p, paper.start[1]}, new int[] {paper.end[0], paper.end[1]}));
				} else {
					paperList.add(new Paper(new int[] {paper.start[0], paper.start[1]}, new int[] {paper.end[0], p}));
					paperList.add(new Paper(new int[] {paper.start[0], p}, new int[] {paper.end[0], paper.end[1]}));
				}
				
				deleteIndexList.add(paper); // 완료한 종이 삭제리스트에 추가
			}
			paperList.removeAll(deleteIndexList);
		}
		for (int i = 0; i < paperList.size(); i++) {
			paperList.get(i).넓이계산하기();
		}
		paperList.sort((p1, p2) -> p2.area - p1.area);
		System.out.println(paperList.get(0).area);
		
	}
}
