class Solution {
	public int[] solution(int brown, int red) {
		int[] answer = new int[2];
		int x, y, size = brown + red;
		
		for (x = size; x > 0; x--) {
			if ((size) % x == 0) {
				y = (size) / x;
				if ((x - 2) * (y - 2) == red) {
					answer[0] = x;
					answer[1] = y;
					break;
				}
			}
		}
		return answer;
	}
}
