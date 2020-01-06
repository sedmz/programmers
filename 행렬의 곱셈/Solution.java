class Solution {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[0].length; j++) {
				int sum = 0;
				for (int k = 0; k < arr2.length; k++) {
					sum = sum + arr1[i][k] * arr2[k][j];
				}
				answer[i][j] = sum;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
  	// sol.solution(new int[][] { { 1, 4 }, { 3, 2 }, { 4, 1 } }, new int[][] { { 3, 3 }, { 3, 3 } });
		// sol.solution(new int[][] { { 1, 0 }, { 3, 2 }, { 4, 0 } }, new int[][] { { 0, 3 }, { -2, 3 } });
		sol.solution(new int[][] { { 1 }, { 2 }, { 7 } }, new int[][] { { 2 } });

	}
}
