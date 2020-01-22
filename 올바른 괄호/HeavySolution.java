import java.util.Stack;

class Solution {
	boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		char characters[] = s.toCharArray();
		if (s.length() % 2 == 1)
			return false;

		int size = 0, rest = s.length();
		for (char ch : characters) {
			if (size > rest)
				return false;
			else if (stack.isEmpty()) {
				if (ch == ')')
					return false;
				stack.push(ch);
				size++;
			} else if (stack.peek() == '(' && ch == ')') {
				stack.pop();
				size--;
			} else {
				stack.push(ch);
				size++;
			}
			rest--;
		}

		if (stack.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((";
		System.out.println(sol.solution(s));
	}
}
