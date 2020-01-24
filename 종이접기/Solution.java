class Solution {
	public int[] solution(int n) {
		StringBuffer paper = new StringBuffer("0");
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= paper.length(); j += 2) {
				if (j % 4 == 0)
					paper.insert(j, "0");
				else
					paper.insert(j, "1");
			}
		}
		
		int[] answer = new int[paper.length()];
		for (int i = 0; i < paper.length(); i++)
			answer[i] = paper.charAt(i) - '0';

		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(4);
	}
}
