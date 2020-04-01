class Solution {
	public int solution(String str) {
		int answer = 1;

		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j <= 1; j++) {
				int low = i - 1, high = i + j;
				while (low >= 0 && high < str.length()) {
					if (str.charAt(low) != str.charAt(high))
						break;
					answer = Math.max(answer, high - low + 1);
					low--;
					high++;
				}
			}
		}

		return answer;

	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("ababaefghijklmnopqrstuvwxyz"));
	}
}
