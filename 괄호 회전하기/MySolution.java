import java.util.*;

class Solution {
	public int solution(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		for (int i = 0; i < s.length(); i++) {
			String string = (s + s).substring(i, i + s.length());

			Stack<Character> stack = new Stack<>();
			int cnt = 0;

			for (char ch : string.toCharArray()) {
				if (stack.isEmpty()) {
					cnt++;
				}

				if (map.containsKey(ch)) {
					stack.add(ch);
				} else if (!stack.isEmpty() && map.get(stack.peek()) == ch) {
					stack.pop();
				} else {
					stack.add('X');
					break;
				}
			}

			if (stack.isEmpty()) {
				return cnt;
			}
		}

		return 0;
	}
}
