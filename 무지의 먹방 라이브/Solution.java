import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

class Solution {
	HashMap<Integer, Integer> count = new LinkedHashMap<>();
	PriorityQueue<Integer> number = new PriorityQueue<>();

	public void init(int[] food_times) {
		for (int time : food_times)
			count.put(time, count.getOrDefault(time, 0) + 1);

		number.addAll(count.keySet());
	}

	public int solution(int[] food_times, long k) {
		init(food_times);

		long size = food_times.length;
		int beforeMin = 0;

		while (!number.isEmpty()) {
			int min = number.poll();
			int diff = min - beforeMin;

			if (k < diff * size) {
				k %= size;
				for (int i = 0; i < food_times.length; i++) {
					if (food_times[i] > beforeMin) {
						if (k-- == 0)
							return i + 1;
					}
				}
			}
			k -= diff * size;
			size -= count.get(min);
			beforeMin = min;
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] food_times = { 3, 1, 2, 1 };
		long k = 7;
		int answer = sol.solution(food_times, k);
		System.out.println("answer = " + answer);
	}
}

