import java.util.*;

class Solution {
	Queue<int[]> locations;
	Queue<Integer> costs;
	Queue<String> directions;
	int[][] board;

	public int solution(int[][] board) {
		this.board = board;

		int money[][] = new int[board.length][board.length];
		for (int i = 0; i < money.length; i++)
			Arrays.fill(money[i], Integer.MAX_VALUE);

		locations = new LinkedList<>();
		costs = new LinkedList<>();
		directions = new LinkedList<>();

		locations.add(new int[] { 0, 0 });
		costs.add(-500);
		directions.add("");

		int min = Integer.MAX_VALUE;

		while (!locations.isEmpty()) {
			int[] location = locations.poll();
			int i = location[0], j = location[1];
			int cost = costs.poll();
			String dir = directions.poll();

			if (cost > min) {
				continue;
			} else if (i == board.length - 1 && j == board.length - 1) {
				min = cost;
				continue;
			} else if (money[i][j] < cost) {
				continue;
			}

			money[i][j] = cost;

			if (hasWall(i + 1, j)) {
				addQueues(i + 1, j, cost, dir, "down");
			}
			if (hasWall(i - 1, j)) {
				addQueues(i - 1, j, cost, dir, "up");
			}
			if (hasWall(i, j + 1)) {
				addQueues(i, j + 1, cost, dir, "right");
			}
			if (hasWall(i, j - 1)) {
				addQueues(i, j - 1, cost, dir, "left");
			}

		}
		return min;
	}

	public void addQueues(int i, int j, int cost, String dir1, String dir2) {
		locations.add(new int[] { i, j });
		costs.add(cost + (dir1.equals(dir2) ? 100 : 600));
		directions.add(dir2);
	}

	public boolean hasWall(int i, int j) {
		return i < board.length && j < board.length && i >= 0 && j >= 0 && board[i][j] == 0;
	}
}
