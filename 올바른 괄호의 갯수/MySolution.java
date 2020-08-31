class Solution {
	public int dfs(int open, int close) {
		if (open == 0 && close == 0) {
			return 1;
		} else if (open < 0) {
			return 0;
		} else if (close < 0 || close < open) {
			return 0;
		}

		return dfs(open - 1, close) + dfs(open, close - 1);
	}

	public int solution(int n) {
		return dfs(n - 1, n);
	}
}
