import java.util.Arrays;

class Solution {
	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);

		int result = 0, n = B.length - 1;
		for (int i = 0; i < A.length; i++) {
			int a = A[i];
			int b = B[n - i];
			result += a * b;
		}
		return result;
	}
}
