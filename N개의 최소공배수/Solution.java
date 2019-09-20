class Solution {
	public int solution(int[] arr) {
		int max = arr[0];
		for (int num : arr) {
			if (num > max)
				max = num;
		}

		int i = max;
		while (true) {
			int cnt = 0;
			for (int num : arr) {
				if (i % num == 0)
					cnt++;
			}
			if (cnt == arr.length)
				return i;
			else
				i++;
		}
	}
}
