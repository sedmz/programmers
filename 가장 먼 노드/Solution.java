import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
	public static final int MAX_NUM = 100000000;
	Set<Integer> connect[];
	Set<Integer> set;
	Queue<Integer> queue;
	int[] cnt;

	public int countMax(int[] array) {
		int cnt = 0, max = 0;
		for (int arr : array) {
			if (MAX_NUM > arr) {
				if (arr > max) {
					max = arr;
					cnt = 1;
				} else if (max == arr) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public void init(int n, int[][] edge) {
		connect = new HashSet[n + 1];
		for (int i = 0; i < connect.length; i++)
			connect[i] = new HashSet<Integer>();

		for (int[] e : edge) {
			connect[e[0]].add(e[1]);
			connect[e[1]].add(e[0]);
		}

		queue = new LinkedList<>();
		queue.add(1);

		set = new HashSet<>();
		for (int i = 2; i <= n; i++)
			set.add(i);

		cnt = new int[n + 1];
		for (int i = 2; i < cnt.length; i++)
			cnt[i] = MAX_NUM;
	}

	public int solution(int n, int[][] edge) {
		init(n, edge);

		while (!queue.isEmpty()) {
			int from = queue.poll();

			for (int to : connect[from]) {
				cnt[to] = Math.min(cnt[to], cnt[from] + 1);
				if (set.contains(to)) {
					queue.add(to);
					set.remove(to);
				}
			}
		}
		return countMax(cnt);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(
				sol.solution(6, new int[][] { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } }));
	}
}
