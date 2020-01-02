import java.util.Stack;

class Solution {
	char[][] block;
	boolean[][] shouldBeRemoved;

	public boolean search() {
		boolean isChanged = false;
		for (int i = 0; i < block.length - 1; i++) {
			for (int j = 0; j < block[i].length - 1; j++) {
				if (block[i][j] == '-')
					continue;
				if (block[i][j] == block[i][j + 1]) {
					if (block[i][j] == block[i + 1][j]) {
						if (block[i][j] == block[i + 1][j + 1]) {
							isChanged = true;
							shouldBeRemoved[i][j] = true;
							shouldBeRemoved[i][j + 1] = true;
							shouldBeRemoved[i + 1][j] = true;
							shouldBeRemoved[i + 1][j + 1] = true;
						}
					}
				}
			}
		}
		return isChanged;
	}

	public void remove() {
		for (int j = 0; j < block[0].length; j++) {
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < block.length; i++) {
				if (shouldBeRemoved[i][j] == true)
					block[i][j] = '-';
				if (block[i][j] != '-')
					stack.add(block[i][j]);
			}
			for (int i = block.length - 1; i >= 0; i--) {
				if (stack.isEmpty())
					block[i][j] = '-';
				else
					block[i][j] = stack.pop();
			}
		}
	}

	public int countRemovedBlock() {
		int cnt = 0;
		for (int i = 0; i < shouldBeRemoved.length; i++) {
			for (int j = 0; j < shouldBeRemoved[i].length; j++) {
				if (block[i][j] == '-')
					cnt++;
			}
		}
		return cnt;
	}

	public int solution(int m, int n, String[] board) {
		block = new char[m][n];
		for (int i = 0; i < m; i++)
			block[i] = board[i].toCharArray();

		boolean isChanged;
		do {
			shouldBeRemoved = new boolean[m][n];
			isChanged = search();
			remove();
		} while (isChanged);

		return countRemovedBlock();
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int m = 4;
		int n = 5;
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		sol.solution(m, n, board);
	}
}
