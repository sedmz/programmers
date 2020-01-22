class Solution {
	public long dfs(int sum, int val, int n) {
		sum += val;
		if (sum > n) {
			return 0;
		} else if (sum == n) {
			return 1;
		} else {
			return dfs(sum, 1, n) + dfs(sum, 2, n);
		}
	}

	public long solution(int n) {
		return dfs(0, 0, n) % 1234567;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		long answer = sol.solution(4);
		System.out.println(answer);
	}
}
