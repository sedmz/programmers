class Solution {
	public String solution(int n) {
		String[] arr = { "수", "박" };

		String answer = "";
		for (int i = 0; i < n; i++)
			answer = answer + arr[i % 2];

		return answer;
	}
}
