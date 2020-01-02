import java.util.Stack;

class Solution {
	boolean[][] isRemove;
	char[][] block;

	public boolean search() {
		boolean b = false;
		for (int i = 0; i < block.length - 1; i++) {
			for (int j = 0; j < block[i].length - 1; j++) {
				if (block[i][j] != '-') {
					if (block[i][j] == block[i][j + 1]) {
						if (block[i][j] == block[i + 1][j]) {
							if (block[i][j] == block[i + 1][j + 1]) {
								b = true;
								isRemove[i][j] = true;
								isRemove[i][j + 1] = true;
								isRemove[i + 1][j] = true;
								isRemove[i + 1][j + 1] = true;
							}
						}
					}
				}
			}
		}
		return b;
	}

	public void remove() {
		for (int j = 0; j < block[0].length; j++) {
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < block.length; i++) {
				System.out.println(i + " " + j);
				if (isRemove[i][j] == true)
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
		for (int i = 0; i < isRemove.length; i++) {
			for (int j = 0; j < isRemove[i].length; j++) {
				if (block[i][j] == '-')
					cnt++;
			}
		}
		return cnt;
	}

	public void reset(int m, int n) {
		isRemove = new boolean[m][n];
	}

	public int solution(int m, int n, String[] board) {
		isRemove = new boolean[m][n];
		block = new char[m][n];
		for (int i = 0; i < m; i++)
			block[i] = board[i].toCharArray();

		while (search()) {
			remove();
			reset(m, n);
		}

		return countRemovedBlock();
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int m = 4;
		int n = 5;
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		int answer = sol.solution(m, n, board);
		System.out.println(answer);
	}
}
