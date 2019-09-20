class Solution {
	public String solution(String s, int n) {
		StringBuilder str = new StringBuilder(s);
		for (int i = 0; i < s.length(); i++) {
			if (str.charAt(i) != ' ') {
				if (str.charAt(i) < 97)
					str.setCharAt(i, (char) ((str.charAt(i) + n - 65) % 26 + 65));
				else
					str.setCharAt(i, (char) ((str.charAt(i) + n - 97) % 26 + 97));
			}
		}
		return str.toString();
	}
}
