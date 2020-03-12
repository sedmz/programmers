class Solution {
	int MOD = 20170805;
	int route[][];
	int cityMap[][];

	public int leftValue(int i, int j) {
		if (i < 0 || j < 0)
			return 0;

		switch (cityMap[i][j]) {
		case 0:
			return route[i][j];
		case 2:
			return leftValue(i, j - 1);
		}
		return 0;
	}

	public int upValue(int i, int j) {
		if (i < 0 || j < 0)
			return 0;

		switch (cityMap[i][j]) {
		case 0:
			return route[i][j];
		case 2:
			return upValue(i - 1, j);
		}
		return 0;
	}

	public int solution(int m, int n, int[][] cityMap) {
		this.cityMap = cityMap;

		route = new int[m][n];
		route[0][0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int left = leftValue(i, j - 1);
				int up = upValue(i - 1, j);
				route[i][j] += (left + up) % MOD;
			}
		}

		return route[m - 1][n - 1];
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(3, 3, new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } });
		sol.solution(3, 6, new int[][] { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } });
	}
}
