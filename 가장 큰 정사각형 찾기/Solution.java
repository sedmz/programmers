class Solution {
	int[][] board;

	public int getSize(int i, int j) {
		if (i > 0 && j > 0 && board[i][j] > 0)
			return Math.min(board[i][j - 1], Math.min(board[i - 1][j - 1], board[i - 1][j]));
		return 0;
	}

	public int solution(int[][] board) {
		this.board = board;

		int max = -1;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] += getSize(i, j);
				max = Math.max(board[i][j], max);
			}
		}
		return max * max;
	}
}
