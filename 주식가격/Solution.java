class Solution {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
	
        for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j <= prices.length; j++) {
				if (j == prices.length) {
					answer[i] = j - 1 - i;
				} else if (prices[i] > prices[j]) {
					answer[i] = j - i;
					break;
				}
			}
		}
		return answer;
	}
}
