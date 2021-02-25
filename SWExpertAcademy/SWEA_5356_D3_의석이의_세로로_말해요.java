package date0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5356_D3_의석이의_세로로_말해요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			char[][] line = new char[5][];
			int maxLength = 0;
			for (int i = 0; i < 5; i++) {
				String s = br.readLine();
				line[i] = new char[s.length()];
				
				for (int j = 0; j < s.length(); j++) {
					line[i][j] = s.charAt(j);
				}
				if (maxLength < line[i].length)
					maxLength = line[i].length;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < maxLength; i++) {
				for (int j = 0; j < 5; j++) {
					if (i < line[j].length) {
						sb.append(line[j][i]);
					}
				}
			}
			System.out.println("#" + t + " " + sb.toString());
		}
	}
}
