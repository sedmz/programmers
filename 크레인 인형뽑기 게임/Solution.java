import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
	public int solution(int[][] board, int[] moves) {
		int size = board.length;

		Queue<Integer>[] queue = new Queue[size];
		for (int i = 0; i < size; i++)
			queue[i] = new LinkedList<Integer>();

		for (int[] b : board) {
			for (int i = 0; i < size; i++) {
				if (b[i] > 0) {
					queue[i].add(b[i]);
				}
			}
		}

		Stack<Integer> stack = new Stack<>();
		stack.add(-1);

		int cnt = 0;
		for (int move : moves) {
			if (queue[move - 1].isEmpty())
				continue;

			int before = stack.peek();
			int now = queue[move - 1].poll();

			if (before != now) {
				stack.add(now);
			} else {
				stack.pop();
				cnt++;
			}
		}

		return cnt * 2;
	}
}
