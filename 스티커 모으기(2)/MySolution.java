class Solution {
	public int solution(int sticker[]) {
		if (sticker.length == 1) {
			return sticker[0];
		}

		int[][] sum = new int[2][sticker.length];
		
		sum[0][0] = sticker[0];
		sum[1][0] = 0;
		sum[0][1] = sticker[0];
		sum[1][1] = sticker[1];

		for (int i = 2; i < sticker.length; i++) {
			sum[0][i] = Math.max(sum[0][i - 1], sum[0][i - 2] + sticker[i]);
			sum[1][i] = Math.max(sum[1][i - 1], sum[1][i - 2] + sticker[i]);
		}

		return Math.max(sum[0][sticker.length - 2], sum[1][sticker.length - 1]);
	}
}
