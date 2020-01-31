import java.util.ArrayList;

class Solution {
	public long getFactorial(int n) {
		long result = 1;
		for (int i = n; i > 1; i--)
			result *= i;
		return result;
	}

	public int[] solution(int n, long k) {
		ArrayList<Integer> answer = new ArrayList<>();
		ArrayList<Integer> number = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			number.add(i);

		long m = getFactorial(n);
		while (number.size() > 1) {
			m /= n--;
			int idx = (int) ((k - 1) / m) + 1;
			answer.add(number.get(idx));
			number.remove(idx);
			k = (k - 1) % m + 1;
		}
		return toArray(answer);
	}

	public int[] toArray(ArrayList<Integer> list) {
		int[] array = new int[list.size()];
		for (int i = 0; i < array.length; i++)
			array[i] = list.get(i);
		return array;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(3, 5);
	}
}
