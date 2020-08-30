import java.util.Arrays;

class Solution {
	public int dpSubArray(int start, int end, int[] money) {
		int[] dp = money.clone();

		int max = 0;
		for (int i = start; i < end; i++) {
			int subMax = dp[i];

			if (i > start)
				subMax = Math.max(dp[i - 1], subMax);
			if (i > start + 1)
				subMax = Math.max(dp[i - 2] + dp[i], subMax);
			
			dp[i] = subMax;
			max = Math.max(dp[i], max);
		}
		return max;
	}

	public int solution(int[] money) {
		int a = dpSubArray(0, money.length - 1, money);
		int b = dpSubArray(1, money.length, money);
		return Math.max(a, b);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int answer = sol.solution(new int[] { 1, 2, 3, 1 });
		System.out.println(answer);
	}
}
