import java.util.Stack;

class Solution {
	String u, v;

	public void setUV(String p) {
		int left = 0, right = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(')
				left++;
			else if (p.charAt(i) == ')')
				right++;

			if (left == right) {
				u = p.substring(0, i + 1);
				v = p.substring(i + 1);
				break;
			}
		}
	}

	public boolean isRightParenthesis(String u) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < u.length(); i++) {
			if (stack.isEmpty())
				stack.push(u.charAt(i));
			else if (stack.peek() == '(' && u.charAt(i) == ')')
				stack.pop();
			else
				stack.push(u.charAt(i));
		}
		if (stack.isEmpty())
			return true;
		return false;
	}

	public String reverse(String p) {
		String answer = "";
		for (int i = 1; i < p.length() - 1; i++) {
			if (p.charAt(i) == '(')
				answer += ")";
			else
				answer += "(";
		}
		return answer;
	}

	public String convert(String p) {
		String answer = "";

		if (p.length() == 0)
			return answer;

		setUV(p);
		if (isRightParenthesis(u)) {
			answer = answer + u + convert(v);
		} else {
			String reverseU = reverse(u);
			answer = answer + '(' + convert(v) + ')'+reverseU;
		}
		return answer;
	}

	public String solution(String p) {
		return convert(p);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		String answer = sol.solution("()))((()");
		String answer = sol.solution("()))((");
		System.out.println(answer);
	}
}
