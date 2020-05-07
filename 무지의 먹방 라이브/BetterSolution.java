// 다른 사람의 풀이보고 개선, Better인지는 모르겠음

import java.util.ArrayList;

class Solution {
	public class Food {
		int idx, value;

		public Food(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
	}

	public int solution(int[] food_times, long k) {
		ArrayList<Food> foods = new ArrayList<>();
		for (int i = 0; i < food_times.length; i++)
			foods.add(new Food(i + 1, food_times[i]));

		while (!foods.isEmpty()) {
			long n = k / foods.size();
			k %= foods.size();

			for (int i = 0; i < foods.size(); i++) {
				foods.get(i).value -= n;
				if (foods.get(i).value < 0)
					k -= foods.get(i).value;
			}
			foods.removeIf(food -> food.value <= 0);

			if (k < foods.size()) {
				return foods.get((int) k).idx;
			}
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
