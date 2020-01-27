import java.util.Stack;

class Solution {
	public int solution(int n) {
		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		stack.add(2);

		int answer = 0;
		while (!stack.isEmpty()) {
			int value = stack.pop();
			if (value == n) {
				answer = ++answer % 1000000007;
			} else if (value < n) {
				stack.add((value + 1) % 100000000);
				stack.add((value + 2) % 100000000);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(8));
	}
}
