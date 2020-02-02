import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
	boolean solution(String s) {
		char[] charArray = s.toCharArray();

		int cnt = 0;
		for (char ch : charArray) {
			cnt = ch == '(' ? cnt + 1 : cnt - 1;
			if (cnt < 0)
				return false;
		}
		return cnt == 0;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "(())()";
		System.out.println(sol.solution(s));
	}
}
