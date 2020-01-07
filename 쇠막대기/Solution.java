import java.util.Stack;

class Solution {
	public int solution(String arrangement) {
		arrangement = arrangement.replaceAll("\\(\\)", "O");
		Stack<Character> stack = new Stack<>();
		char character[] = arrangement.toCharArray();

		int answer = 0;
		for (char ch : character) {
			if (ch == 'O') {
				answer += stack.size();
			} else if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') {
				stack.pop();
				answer++;
			} else {
				stack.push(ch);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "()(((()())(())()))(())";
		System.out.println(sol.solution(s));
	}
}
