import java.util.Arrays;

class Solution {
	public int solution(int[] d, int budget) {
		Arrays.sort(d);

		int sum = 0;
		for (int i = 0; i < d.length; i++) {
			if (sum + d[i] > budget)
				return i;
			sum += d[i];
		}
		return d.length;
	}
}
