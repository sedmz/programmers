class Solution {
	public String solution(String s) {
		boolean[] b = new boolean[s.length()];
		for (int i = 0; i < b.length; i++)
			b[i] = true;

		String answer = "";
		for (int i = 0; i < s.length(); i++) {
			int max = -1, idx = -1;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) > max && b[j] == true) {
					max = s.charAt(j);
					idx = j;
				}
			}
			answer = answer + (char) max;
			b[idx] = false;
		}
		return answer;
	}
}
