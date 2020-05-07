// 다른 사람의 풀이 보고 개선

import java.util.ArrayList;

class Solution {
	ArrayList<int[]> foods = new ArrayList<>();

	public int solution(int[] food_times, long k) {
		for (int i = 0; i < food_times.length; i++)
			foods.add(new int[] { i + 1, food_times[i] });

		while (!foods.isEmpty()) {
			long n = k / foods.size();
			k %= foods.size();

			for (int i = 0; i < foods.size(); i++) {
				foods.get(i)[1] -= n;
				if (foods.get(i)[1] < 0)
					k -= foods.get(i)[1];
			}
			foods.removeIf(food -> food[1] <= 0);

			if (k < foods.size())
				return foods.get((int) k)[0];
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
