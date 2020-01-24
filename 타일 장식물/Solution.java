import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public long solution(int N) {
		Queue<Long> queue = new LinkedList<>();
		queue.add((long)2);
		queue.add((long)2);
		
		for (int i = 1; i < N; i++)
			queue.add(queue.poll() + queue.peek());
		return queue.poll()+queue.poll();
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(80));
	}
}
