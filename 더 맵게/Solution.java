import java.util.Arrays;

class Solution {
	int[] scoville;

	public int removeIdx() {
		for (int i = scoville.length - 1; i >= 0; i--)
			if (scoville[i] != 10000001)
				return i;
		return -1;
	}

	public void remove(int idx) {
		int a, b, lastIdx = removeIdx();
		swap(idx, lastIdx);
		scoville[lastIdx] = 10000001;

		for (int i = 0; i < lastIdx;) {
			if (i == 0) {
				a = 1;
				b = 2;
			} else {
				a = i * 2 + 1;
				b = (i + 1) * 2;
			}
			if (a >= lastIdx || b >= lastIdx) {
				return;
			}

			if (scoville[a] > scoville[b]) {
				if (scoville[i] > scoville[b]) {
					swap(i, b);
					i = b;
				} else
					return;
			} else {
				if (scoville[i] > scoville[a]) {
					swap(i, a);
					i = a;
				} else
					return;
			}
		}
	}

	public int insertIdx() {
		for (int i = 0; i < scoville.length; i++)
			if (scoville[i] == 10000001)
				return i;
		return scoville.length;
	}

	public void insert(int val) {
		int idx = insertIdx();
		scoville[idx] = val;
		while (idx > 0) {
			if (scoville[idx] < scoville[(idx - 1) / 2]) {
				swap(idx, (idx - 1) / 2);
				idx = (idx - 1) / 2;
			} else {
				return;
			}
		}
	}

	public void swap(int i, int j) {
		int tmp = scoville[i];
		scoville[i] = scoville[j];
		scoville[j] = tmp;
	}

	public int solution(int[] scoville, int K) {
		Arrays.parallelSort(scoville);
		this.scoville = scoville;
		if (scoville[0] > K)
			return -1;
		else if (scoville[0] == 0 && scoville[1] == 0)
			return -1;
		else if (scoville.length == 1)
			return -1;

		int cnt = 0;
		while (true) {
			if (scoville[1] == 10000001)
				return -1;

			int secondIdx = 1;
			if (scoville.length > 2)
				secondIdx = scoville[1] > scoville[2] ? 2 : 1;

			int result = scoville[0] + scoville[secondIdx] * 2;
			remove(0);
			remove(0);
			insert(result);
			cnt++;
			if (scoville[0] >= K)
				break;
		}

		System.out.println("answer = " + cnt);
		return cnt;
	}

	public void show() {
		System.out.println("(show)");
		for (int i = 0; i < scoville.length; i++)
			System.out.print(" " + scoville[i]);
		System.out.println();
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		// sol.solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7);
		// sol.solution(new int[] { 0, 1 }, 3);
		sol.solution(new int[] { 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6 }, 100);

	}
}
