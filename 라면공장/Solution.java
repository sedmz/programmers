import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

	public int solution(int stock, int[] dates, int[] supplies, int k) {
		int cnt = 0;
		for (int i = 0, j = 0; i < k; i++) {
			if (j < dates.length) {
				if (dates[j] == i) {
					queue.add(supplies[j]);
					j++;
				}
			}

			if (stock == 0) {
				stock += queue.poll();
				cnt++;
			}
			stock--;
		}
		return cnt;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(4, new int[] { 4, 10, 15 }, new int[] { 20, 5, 10 }, 34));
	}
}
