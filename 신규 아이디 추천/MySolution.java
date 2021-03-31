import java.util.Stack;

class Solution {
	public String solution(String new_id) {
		int MAX_LENGTH = 15;

		Stack<Character> stack = new Stack<>();
		for (char ch : new_id.toCharArray()) {
			if (stack.size() == MAX_LENGTH) {
				break;
			}
			
			if (Character.isLetter(ch)) {
				stack.add(Character.toLowerCase(ch));
			} else if (Character.isDigit(ch)) {
				stack.add(ch);
			} else if (ch == '-' || ch == '_') {
				stack.add(ch);
			} else if (ch == '.') {
				if (!stack.isEmpty() && stack.peek() != '.') {
					stack.add(ch);
				}
			}
		}
		
		if (!stack.isEmpty() && stack.peek() == '.') {
			stack.pop();
		}
		
		if (stack.isEmpty()) {
			stack.add('a');
		}
		
		while (stack.size() < 3) {
			stack.add(stack.lastElement());
		}
		
		StringBuffer recommended = new StringBuffer("");
		for (char ch : stack) {
			recommended.append(ch);
		}
	
		return recommended.toString();
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		String answer = sol.solution("abcdefghijklmn.p");
		System.out.println(answer);
	}
}
