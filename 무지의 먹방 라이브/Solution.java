// 왜 min을 Int형으로 바꾸면 오류가 나는지 모르겠다

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;

class Solution {
	ArrayList<int[]> times = new ArrayList<>();

	public void init(int[] food_times) {
		HashMap<Integer, Integer> map = new LinkedHashMap<>();
		for (int time : food_times)
			map.put(time, map.getOrDefault(time, 0) + 1);

		for (int time : map.keySet()) {
			times.add(new int[] { map.get(time), time });
		}
	}

	public void sortByValue() {
		Collections.sort(times, new Comparator() {
			public int compare(Object o1, Object o2) {
				int a = ((int[]) o1)[1];
				int b = ((int[]) o2)[1];

				if (a == b) {
					a = ((int[]) o1)[0];
					b = ((int[]) o2)[0];
				}
				return ((Comparable) a).compareTo(b);
			}
		});
	}

	public int solution(int[] food_times, long k) {
		init(food_times);
		sortByValue();

		long size = food_times.length, min = 0;
		long firstValue = times.get(0)[1];

		while ((firstValue - min) * size <= k) {
			k -= (firstValue - min) * size;
			size -= times.get(0)[0];
			min = firstValue;
			times.remove(0);
			if (times.isEmpty())
				return -1;
			firstValue = times.get(0)[1];
		}

		k %= size;
		int cnt = 0, i = 0;
		while (true) {
			if (food_times[i++] > min) {
				if (cnt++ == k)
					return i;
			}
		}
	}
}

