
class Solution {
	public int solution(String s) {
		int answer = 0;
		int mul = 1, diff = '1' - 1;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (Character.isDigit(s.charAt(i))) {
				int n = (int) s.charAt(i) - diff;
				answer += n * mul;
				mul *= 10;
			} else if (s.charAt(i) == '-') {
				answer *= -1;
			}
		}
		return answer;
	}
}
