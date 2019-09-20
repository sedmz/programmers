class Solution {
	public int solution(int num) {
		long number = (long) num;

		int cnt = 0;
		while (number != 1) {
			if (number % 2 == 0)
				number /= 2;
			else
				number = number * 3 + 1;

			if (++cnt > 500)
				return -1;
		}
		return cnt;
	}
}
