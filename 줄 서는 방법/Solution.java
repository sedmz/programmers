import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public long getFactorial(int n) {
		long result = 1;
		for (int i = n; i > 1; i--)
			result *= i;
		return result;
	}

	public int[] solution(int n, long k) {
		int[] answer = new int[n];
		ArrayList<Integer> number = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			number.add(i);

		int i = 0;
		long m = getFactorial(n);
		while (number.size() > 1) {
			m /= n--;
			int idx = (int) ((k - 1) / m) + 1;
			answer[i++] = number.get(idx);
			number.remove(idx);
			k = (k - 1) % m + 1;
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(3, 5);
	}
}
