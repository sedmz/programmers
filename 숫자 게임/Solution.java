import java.util.Arrays;

class Solution {
	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);

		int cnt = 0;
		int a = 0, b = 0, n = A.length;
		while (b < n && a < n) {
			if (A[a] < B[b]) {
				cnt++;
				a++;
			}
			b++;
		}
		return cnt;
	}

	public static void main(String[] ars) {
		Solution sol = new Solution();
		sol.solution(new int[] { 4, 3, 2, 1 }, new int[] { 1, 2, 3, 4 });
	}
}
