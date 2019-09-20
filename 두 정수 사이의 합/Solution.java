class Solution {
	public long solution(int a, int b) {
		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		long sum = 0;
		for (int n = a; n <= b; n++)
			sum += n;
		
		return sum;
	}
}
