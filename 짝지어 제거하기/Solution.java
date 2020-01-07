import java.util.Stack;

class Solution {
	public int solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty())
				stack.push(s.charAt(i));
			else if (stack.peek() == s.charAt(i))
				stack.pop();
			else
				stack.push(s.charAt(i));
		}
		if (stack.isEmpty())
			return 0;
		else
			return 1;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("baabaa"));
	}
}
