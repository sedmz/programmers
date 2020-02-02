class Solution {
	public boolean isSquare(int[][] board, int i, int j) {
		if (board[i][j] == board[i + 1][j]) {
			if (board[i][j] == board[i][j + 1]) {
				if (board[i][j] == board[i + 1][j + 1]) {
					return true;
				}
			}
		}
		return false;
	}

	public int solution(int[][] board) {
		int cnt, max = 0, level = 0;

		do {
			cnt = 0;
			for (int i = 0; i < board.length - 1; i++) {
				for (int j = 0; j < board[i].length - 1; j++) {
					if (board[i][j] > level) {
						if (isSquare(board, i, j)) {
							++board[i][j];
							cnt++;
						}
					}
				}
			}
			level++;
		} while (cnt > 0);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] > max)
					max = board[i][j];
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		return max * max;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//	int answer = sol.solution(new int[][] { { 0, 0, 1, 1 }, { 1, 1, 1, 1 } });
//	int answer = sol.solution(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } });
		int answer = sol.solution(new int[][] { { 1 } });
		System.out.println(answer);
	}
}
