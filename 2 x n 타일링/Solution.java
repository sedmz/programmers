class Solution {
	public int solution(int n) {
		long[] arr = new long[600001];
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				arr[0] = 1;
				arr[1] = 1;
				continue;
			}
			arr[i] = arr[i - 1] + arr[i - 2];
			arr[i] %= 1000000007;
		}
		return (int) arr[n];
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(8));
	}
}
