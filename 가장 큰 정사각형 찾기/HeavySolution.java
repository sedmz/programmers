import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
		Queue<Integer[]> queue = new LinkedList<>();
		for (int i = 0; i < board.length - 1; i++) {
			for (int j = 0; j < board[i].length - 1; j++) {
				queue.add(new Integer[] { i, j });
			}
		}

		while (!queue.isEmpty()) {
			Integer[] xy = queue.poll();
			int i = xy[0];
			int j = xy[1];
			if (board[i][j] > 0) {
				if (isSquare(board, i, j)) {
					++board[i][j];
					queue.add(new Integer[] { i, j });
				}
			}
		}

		int max = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] > max)
					max = board[i][j];
			}
		}
		return max * max;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//	int answer = sol.solution(new int[][] { { 0, 0, 1, 1 }, { 1, 1, 1, 1 } });
		int answer = sol.solution(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } });
//	int answer = sol.solution(new int[][] { { 1 } });
		System.out.println(answer);
	}
}
