class Solution {
	int[][] arr;
	int min, value, i, j;

	public int[] solution(int rows, int columns, int[][] queries) {
		arr = new int[rows][columns];
		int[] answer = new int[queries.length];

		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = ++cnt;
			}
		}

		int n = 0;
		for (int[] query : queries) {
			min = Integer.MAX_VALUE;
			value = -1;
			i = query[0] - 1;
			j = query[1] - 1;

			move(query[0] - 1, query[3] - 1, 0, 1);
			move(query[2] - 1, query[3] - 1, 1, 0);
			move(query[2] - 1, query[1] - 1, 0, -1);
			move(query[0] - 1, query[1] - 1, -1, 0);

			answer[n++] = min;
		}

		return answer;
	}

	public void move(int endI, int endJ, int dirI, int dirJ) {
		if (value == -1)
			value = arr[i][j];
		i += dirI;
		j += dirJ;

		while (true) {
			min = Math.min(arr[i][j], min);
			int next = arr[i][j];
			arr[i][j] = value;
			value = next;

			if (i == endI && j == endJ) {
				break;
			} else {
				i += dirI;
				j += dirJ;
			}
		}
	}
}
