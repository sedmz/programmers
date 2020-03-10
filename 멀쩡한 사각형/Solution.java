class Solution {
	public long solution(int w, int h) {
		long cnt = (long) w * h;

		double end, start = 0;
		for (int i = 1; i <= h; i++) {
			end = i * (double) w / h;
			int n = (int) end - (int) start;
			if (start == (int) start)
				n--;

			cnt -= n + 1;
			start = end;
		}

		return cnt;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(7135, 1470);
	}
}
