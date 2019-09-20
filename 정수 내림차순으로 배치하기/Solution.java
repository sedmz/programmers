import java.util.ArrayList;

class Solution {
	public long solution(long n) {
		ArrayList<Long> arr = new ArrayList<>();

		while (n > 0) {
			arr.add(n % 10);
			n /= 10;
		}

		arr.sort(null);

		long res = 0, mul = 1;
		for (long num : arr) {
			res += num * mul;
			mul *= 10;
		}

		return res;
	}
}
