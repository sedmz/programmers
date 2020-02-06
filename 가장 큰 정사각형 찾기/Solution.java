class Solution {
	int[][] board;

	public int getMaxSize(int i, int j) {
		int min;
		min = Math.min(board[i][j - 1], board[i - 1][j]);
		min = Math.min(board[i - 1][j - 1], min);
		return min;
	}

	public int solution(int[][] board) {
		this.board = board;

		int max = -1;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i > 0 && j > 0)
					if (board[i][j] > 0)
						board[i][j] += getMaxSize(i, j);
				max = Math.max(board[i][j], max);
			}
		}
		return max * max;
	}
}
