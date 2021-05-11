class Solution {
	int[] answer = { 0, 0 };
	int n = 1;

	public void updateAnswer(int[][] arr, int i, int j) {
		for (int I = 0; I <= n; I += n) {
			for (int J = 0; J <= n; J += n) {
				if (arr[i + I][j + J] != -1) {
					answer[arr[i + I][j + J]]++;
				}
			}
		}
	}

	public int[] solution(int[][] arr) {
		boolean isCompressed = false;

		while (n < arr.length) {
			for (int i = 0; i <= arr.length - n * 2; i += n * 2) {
				for (int j = 0; j <= arr.length - n * 2; j += n * 2) {
					int value = arr[i][j];

					if (value == -1 || value != arr[i + n][j] || value != arr[i][j + n] || value != arr[i + n][j + n]) {
						updateAnswer(arr, i, j);
						arr[i][j] = -1;
						isCompressed = true;
					}
				}
			}
			n *= 2;
		}
		
		if (!isCompressed) {
			answer[arr[0][0]]++;
		}

		return answer;
	}
}
