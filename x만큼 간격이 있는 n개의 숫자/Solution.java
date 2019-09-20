class Solution {
	public long[] solution(int x, int n) {
		long[] arr = new long[n];
		
		long val = 0;
		for (int i = 0; i < n; i++) {
			val += x;
			arr[i] = val;
		}
		
		return arr;
	}
}
