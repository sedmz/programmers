import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int s : scoville)
			queue.add(s);
      
		int cnt = 0;
		if (queue.peek() >= K)
			return cnt;

		while (true) {
			if (queue.size() < 2)
				return -1;
			int a = queue.poll();
			int b = queue.poll();
			if (b == 0)
				return -1;

			queue.add(a + b * 2);
			cnt++;
			if (queue.peek() >= K)
				return cnt;
		}
	}
}
