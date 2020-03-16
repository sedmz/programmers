import java.util.HashSet;
import java.util.Stack;

class Solution {
	class Node {
		HashSet<Integer> set;
		long sum;

		public Node(HashSet<Integer> set, int sum) {
			this.set = set;
			this.sum = sum;
		}
	}

	public HashSet<Integer> add(HashSet<Integer> set, int value) {
		HashSet<Integer> copySet = (HashSet) set.clone();
		copySet.add(value);
		return copySet;
	}

	public int solution(int[] A, int[] B) {
		Stack<Node> stack = new Stack<>();
		stack.add(new Node(new HashSet<>(), 0));

		long min = -1;
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			HashSet<Integer> set = node.set;
			long sum = node.sum;

			if (set.size() == A.length) {
				if (min == -1 || min > sum)
					min = sum;
				continue;
			}

			for (int bIdx = 0; bIdx < B.length; bIdx++) {
				if (!set.contains(bIdx)) {
					if (sum < min || min == -1)
						stack.add(new Node(add(set, bIdx), (int) sum + A[set.size()] * B[bIdx]));
				}
			}
		}
		return (int) min;
	}
}
