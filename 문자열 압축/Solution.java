public class Solution {
	public static int convert(String s, int n) {
		int cnt = 1;
		String now, before = s.substring(0, n);
		String result = "";

		for (int i = n; i < s.length(); i = i + n) {
			if (i + n > s.length())
				n = s.length() - i;
			now = s.substring(i, i + n);

			if (now.equals(before)) {
				cnt++;
			} else {
				if (cnt == 1) {
					result += before;
				} else {
					result = result + Integer.toString(cnt) + before;
					cnt = 1;
				}
				before = now;
			}
		}
		if (cnt == 1) {
			result += before;
		} else {
			result = result + Integer.toString(cnt) + before;
		}

		return result.length();
	}

	public int solution(String s) {
		int minLength = s.length();
		for (int i = 1; i < s.length(); i++) {
			if (minLength <= i)
				break;
			
			int length = convert(s, i);
			if (length < minLength)
				minLength = length;
		}
		return minLength;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		// int answer = sol.solution("aabbaccc");
		int answer = sol.solution("ababcdcdababcdcd");
		// int answer = sol.solution("abcabcdede");
		// int answer = sol.solution("abcabcabcabcdededededede");
		// int answer = sol.solution("xababcdcdababcdcd");
		System.out.println(answer);
	}
}
