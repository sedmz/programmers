import java.util.Arrays;

class Solution {
	public int solution(int[] budgets, int M) {
		Arrays.sort(budgets);

		int n = budgets.length;
		int budget = budgets[0];
		int totalBudget = budget * n;

		if (totalBudget > M)
			return M / n;

		for (int i = 1; i < budgets.length; i++) {
			n--;

			int diff = budgets[i] - budgets[i - 1];
			if (diff * n + totalBudget > M) {
				budget += (M - totalBudget) / n;
				break;
			}
			budget += diff;
			totalBudget += diff * n;
		}
		return budget;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int answer = sol.solution(new int[] { 120, 110, 140, 150 }, 485);
		System.out.println(answer);
	}
}
