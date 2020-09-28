class Solution {
	int[] a;

	public int[] dpByMin(int start, int end, int unit) {
		int[] array = new int[a.length];

		int min = Integer.MAX_VALUE;
		for (int i = start; i != end; i += unit) {
			array[i] = min;
			min = Math.min(a[i], min);
		}
		return array;
	}

	public int solution(int[] a) {
		this.a = a;
		int[] left = dpByMin(0, a.length, 1);
		int[] right = dpByMin(a.length - 1, -1, -1);

		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			if (left[i] > a[i] || right[i] > a[i])
				cnt++;
		}
		return cnt;
	}
}
