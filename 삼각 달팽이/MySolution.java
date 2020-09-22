import java.util.ArrayList;

class Solution {
	int[][] numbers;
	int n, max, N = 1;

	public int[] solution(int n) {
		this.n = n;
		this.max = getMax(n);

		numbers = new int[n][];
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = new int[i + 1];

		for (int i = 0; i <= (n - 1) / 3; i++) {
			down(i);
			right(i);
			up(i);
		}

		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				answer.add(numbers[i][j]);
			}
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	public void down(int idx) {
		if (N == max)
			return;

		for (int i = idx * 2; i < n - idx; i++) {
			numbers[i][idx] = N++;
		}
	}

	public void right(int idx) {
		if (N == max)
			return;

		for (int i = idx + 1; i < numbers[n - 1 - idx].length - idx; i++) {
			numbers[n - 1 - idx][i] = N++;
		}
	}

	public void up(int idx) {
		if (N == max)
			return;

		for (int i = n - 2 - idx; i > idx * 2; i--) {
			numbers[i][numbers[i].length - idx - 1] = N++;
		}
	}

	public int getMax(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++)
			result += i;
		return result;
	}
}
