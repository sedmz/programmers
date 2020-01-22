import java.util.Arrays;

class Solution {
	public int solution(int n) {
		boolean arr[] = new boolean[n + 1];
		Arrays.fill(arr, true);
		for (int i = 2; i < n; i++) {
			for (int j = 2; i * j <= n; j++) {
				arr[i * j] = false;
			}
		}

		int cnt = 0;
		for (int i = 2; i < arr.length; i++)
			if (arr[i] == true)
				cnt++;
		return cnt;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(10);
	}
}
