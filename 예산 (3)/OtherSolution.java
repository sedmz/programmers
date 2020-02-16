import java.util.Arrays;

class Solution {
	public int solution(int[] budgets, int M) {
		Arrays.sort(budgets);

		int start = 0, end = budgets[budgets.length - 1];
		while (start <= end) {
			int mid = (start + end) / 2;

			int sum = 0;
			for (int element : budgets)
				sum += Math.min(element, mid);

			if (sum > M)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return end;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int answer = sol.solution(new int[] { 120, 110, 140, 150 }, 485);
		System.out.println(answer);
	}
}
