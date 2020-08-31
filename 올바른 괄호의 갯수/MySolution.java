import java.util.Stack;

class Solution {
	public int solution(int n) {
		Stack<int[]> stack = new Stack<>();
		stack.add(new int[] { n - 1, n });

		int cnt = 0;
		while (!stack.isEmpty()) {
			int[] bracket = stack.pop();
			int open = bracket[0], close = bracket[1];

			if (open == 0 && close == 0) {
				cnt++;
			}
			if (open > 0) {
				stack.add(new int[] { open - 1, close });
			}
			if (close > 0 && open < close) {
				stack.add(new int[] { open, close - 1 });
			}
		}

		return cnt;
	}
}
