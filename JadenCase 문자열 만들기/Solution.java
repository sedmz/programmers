class Solution {
	public String solution(String s) {
		s = s.toLowerCase();
		StringBuffer sb = new StringBuffer(" " + s);
		for (int i = 0; i < sb.length()-1; i++) {
			if (sb.charAt(i) == ' ' )
				sb.replace(i + 1, i + 2, sb.substring(i + 1, i + 2).toUpperCase());
		}
		return sb.delete(0, 1).toString();
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution("for the last week");
	}
}
