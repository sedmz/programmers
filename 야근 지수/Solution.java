import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public long solution(int n, int[] works) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (int w : works)
			queue.add(w);

		for (int i = 0; i < n; i++) {
			int num = queue.poll();
			queue.add(num - 1);
		}

		long answer = 0;
		while (!queue.isEmpty()) {
			int work = queue.poll();
			if (work < 0)
				work = 0;
			answer += work * work;
		}
		return answer;
	}
}
