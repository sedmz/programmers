class Solution {
	public long getAnswer(long mid, int[] times) {
		long answer = 0;
		for (int time : times) {
			long tmp = mid / time * time;
			if (answer < tmp)
				answer = tmp;
		}
		return answer;
	}

	public long solution(int n, int[] times) {
		long min = Long.MAX_VALUE;
		for (int time : times) {
			if (time < min)
				min = time;
		}

		long l = 0, r = n * min;

		while (true) {
			long mid = (l + r) / 2;

			long N = 0;
			for (int time : times) {
				N += mid / time;
			}

			if (N == n) {
				return getAnswer(mid, times);
			} else if (l > r) {
				return getAnswer(l, times);
			} else if (N < n) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
	}
}
