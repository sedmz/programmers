import java.util.HashMap;

class Solution {
	public int solution(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);

		return Math.min(map.size(), nums.length / 2);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[] { 3, 1, 2, 3 }));
	}
}
