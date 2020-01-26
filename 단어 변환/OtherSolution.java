import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static class Node {
		String next;
		int cnt;

		public Node(String next, int cnt) {
			this.next = next;
			this.cnt = cnt;
		}
	}

	public int solution(String begin, String target, String[] words) {
		Queue<Node> queue = new LinkedList<>();
		boolean[] visit = new boolean[words.length];
		int answer = 0;

		queue.add(new Node(begin, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.next.equals(target)) {
				answer = node.cnt;
				break;
			}
			
			for (int i = 0; i < words.length; i++) {
				if (!visit[i])
					if (isNext(node.next, words[i])) {
						System.out.println(words[i]);
						visit[i] = true;
						queue.add(new Node(words[i], node.cnt + 1));
					}
			}
		}

		return answer;
	}

	static boolean isNext(String cur, String n) {
		int cnt = 0;
		for (int i = 0; i < n.length(); i++) {
			if (cur.charAt(i) != n.charAt(i)) {
				if (++cnt > 1)
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		String begin = "hit";
		String target = "cog";
		String words[] = { "hot", "dot", "dog", "lot", "log", "cog" };
		// String words[] = { "hot", "dot", "dog", "lot", "log" };
		System.out.println(sol.solution(begin, target, words));
	}
}
