package date0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_2108_통계학 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int[] arr = new int[n];
		int sum = 0;
		int val = 0;
		int maxFreq = Integer.MIN_VALUE;
		int maxVal = Integer.MIN_VALUE;
		int minVal = Integer.MAX_VALUE;
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			arr[i] = val = stoi(br.readLine()); 
			sum += val;
			numMap.put(val, numMap.containsKey(val) ? numMap.get(val) + 1 : 1);
			if (numMap.get(val) > maxFreq) {
				maxFreq = numMap.get(val);
			}
			maxFreq = Math.max(maxFreq, numMap.get(val));
			minVal = Math.min(minVal, val);
			maxVal = Math.max(maxVal, val);
		}
		Arrays.sort(arr);
		
		List<Integer> maxFreqValueList = new ArrayList<>();
		for (int key : numMap.keySet()) {
			if (numMap.get(key) == maxFreq) {
				maxFreqValueList.add(key);
			}
		}
		maxFreqValueList.sort((m1, m2) -> m1 - m2);
		System.out.println(Math.round((float)sum / n));
		System.out.println(arr[n / 2]);
		System.out.println(maxFreqValueList.size() > 1 ? maxFreqValueList.get(1) : maxFreqValueList.get(0));
		System.out.println(maxVal - minVal);
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}

