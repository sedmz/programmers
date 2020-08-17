import java.util.Arrays;
import java.util.Stack;

class Solution {
	private Stack<Integer> stack = new Stack<>();
	private int cnt = 0;

	public int solution(int[] people, int limit) {
		Arrays.sort(people);

		for (int i = people.length - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				stack.add(people[i]);
			} else if (stack.peek() + people[i] > limit) {
				stack.add(people[i]);
			} else {
				stack.pop();
				cnt++;
			}
		}
		return cnt + stack.size();

	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int answer = sol.solution(new int[] { 10, 20, 40, 60, 80, 100, 120, 120, 140, 160, 180, 200, 220, 240 }, 240);
		System.out.println(answer);
	}
}
