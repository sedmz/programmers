class Solution {
	public boolean solution(int x) {
		int sum = 0, xx = x;
		while (xx > 0) {
			sum += xx % 10;
			xx /= 10;
		}
		return x % sum == 0;
	}
}
