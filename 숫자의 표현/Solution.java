class Solution {
	public int solution(int n) {
		int sum = 0, cnt = 0, max = n;
		for (int i = n; i > 0; i--) {
			sum += i;
			if (sum >= n) {
				if (sum == n)
					cnt++;
				sum -= max--;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(15));

	}
}
