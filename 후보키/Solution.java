import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
	Queue<Stack<Integer>> queue = new LinkedList<>();
	Queue<Stack<Integer>> candidateKeys = new LinkedList<>();

	public boolean isSkip(Stack<Integer> stack) {
		for (Stack<Integer> key : candidateKeys) {
			int cnt = 0;
			for (int k : key) {
				if (stack.contains(k))
					cnt++;
			}
			if (cnt == key.size()) {
				return true;
			}
		}
		return false;
	}

	public boolean isUnique(Stack<Integer> stack, String[][] relation) {
		HashSet<String> set = new HashSet<String>();

		for (int j = 0; j < relation.length; j++) {
			String str = "";
			for (int i = 0; i < stack.size(); i++) {
				str += relation[j][stack.get(i)] + " ";
			}
			set.add(str);
		}
		return set.size() == relation.length;
	}

	public int solution(String[][] relation) {
		int answer = 0;

		for (int i = 0; i < relation[0].length; i++)
			queue.add(addStack(new Stack<Integer>(), i));

		while (!queue.isEmpty()) {
			Stack<Integer> stack = queue.poll();

			if (isSkip(stack))
				continue;

			if (isUnique(stack, relation)) {
				candidateKeys.add(stack);
				answer++;
			} else {
				for (int i = stack.peek() + 1; i < relation[0].length; i++) {
					queue.add(addStack(stack, i));
				}
			}
		}
		return answer;
	}

	public Stack<Integer> addStack(Stack<Integer> stack, int val) {
		Stack<Integer> newStack = (Stack<Integer>) stack.clone();
		newStack.add(val);
		return newStack;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();

//		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
//				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
//				{ "600", "apeach", "music", "2" } }; // 2

//		  String[][] relation = { { "100", "music", "2" }, { "200", "math", "2" }, {
//		  "300", "computer", "3" }, { "400", "computer", "4" }, { "500", "music", "3"
//		  }, { "600", "music", "2" } }; // 1

//		String[][] relation = { { "200", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
//				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
//				{ "600", "apeach", "music", "2" } }; // 3

//		String[][] relation = { { "a", "b", "c", "d", "e", "f", "g", "1" }, { "a", "b", "c", "d", "e", "f", "g", "2" },
//				{ "a", "b", "c", "d", "e", "f", "g", "3" }, { "a", "b", "c", "d", "e", "f", "g", "4" },
//				{ "a", "b", "c", "d", "e", "f", "g", "5" }, { "a", "b", "c", "d", "e", "f", "g", "6" },
//				{ "a", "b", "c", "d", "e", "f", "g", "7" }, { "a", "b", "c", "d", "e", "f", "g", "8" },
//				{ "a", "b", "c", "d", "e", "f", "g", "9" }, { "a", "b", "c", "d", "e", "f", "g", "10" },
//				{ "a", "b", "c", "d", "e", "f", "g", "11" }, { "a", "b", "c", "d", "e", "f", "g", "12" },
//				{ "a", "b", "c", "d", "e", "f", "g", "13" }, { "a", "b", "c", "d", "e", "f", "g", "14" },
//				{ "a", "b", "c", "d", "e", "f", "g", "15" }, { "a", "b", "c", "d", "e", "f", "g", "16" },
//				{ "a", "b", "c", "d", "e", "f", "g", "17" }, { "a", "b", "c", "d", "e", "f", "g", "18" },
//				{ "a", "b", "c", "d", "e", "f", "g", "19" }, { "a", "b", "c", "d", "e", "f", "g", "20" } }; // 1

//		String[][] relation = { { "z", "b", "c", "z", "z", "g", "f", "1" }, { "z", "b", "c", "d", "z", "z", "f", "2" },
//				{ "a", "b", "c", "d", "e", "f", "g", "3" }, { "b", "b", "c", "d", "e", "f", "g", "4" },
//				{ "c", "b", "c", "d", "e", "f", "g", "5" }, { "d", "b", "c", "d", "e", "f", "g", "6" },
//				{ "e", "b", "c", "d", "e", "f", "g", "7" }, { "f", "b", "c", "d", "e", "f", "g", "8" },
//				{ "g", "b", "c", "d", "e", "f", "g", "9" }, { "h", "b", "c", "d", "e", "f", "g", "10" },
//				{ "i", "b", "c", "d", "e", "f", "g", "11" }, { "j", "b", "c", "d", "e", "f", "g", "12" },
//				{ "k", "b", "c", "d", "e", "f", "g", "13" }, { "l", "b", "c", "d", "e", "f", "g", "14" },
//				{ "m", "b", "c", "d", "e", "f", "g", "15" }, { "n", "b", "c", "d", "e", "f", "g", "16" },
//				{ "o", "b", "c", "d", "e", "f", "g", "17" }, { "p", "b", "c", "d", "e", "f", "g", "18" },
//				{ "q", "b", "c", "d", "e", "f", "g", "19" }, { "z", "b", "c", "d", "z", "g", "f", "20" } }; // 2

//		String[][] relation = { { "1", "2", "3", "4", "5", "6" },
//				{ "1", "2", "3", "4", "5", "6" } };

//		String[][] relation = { { "1", "1", "1", "1", "1", "1", "1", "0" }, { "1", "1", "1", "1", "1", "1", "0", "1" },
//				{ "1", "1", "1", "1", "1", "0", "1", "1" }, { "1", "1", "1", "1", "0", "1", "1", "1" },
//				{ "1", "1", "1", "0", "1", "1", "1", "1" }, { "1", "1", "0", "1", "1", "1", "1", "1" },
//				{ "1", "0", "1", "1", "1", "1", "1", "1" }, { "0", "1", "1", "1", "1", "1", "1", "1" } }; // 8?
//		String[][] relation = { { "1", "1", "1", "1", "1", "1", "1", "0" }, { "1", "1", "1", "1", "1", "1", "0", "1" },
//				{ "1", "1", "1", "1", "1", "0", "1", "1" }, { "1", "1", "1", "1", "0", "1", "1", "1" },
//				{ "1", "1", "1", "0", "1", "1", "1", "1" }, { "1", "1", "0", "1", "1", "1", "1", "1" },
//				{ "1", "0", "1", "1", "1", "1", "1", "1" } }; // 7?

//		String[][] relation = { { "1", "1", "1", "1", "1", "1", "1" }, { "2", "2", "2", "2", "2", "0", "0" },
//				{ "3", "3", "3", "3", "3", "2", "2" }, { "4", "4", "4", "4", "3", "3", "3" },
//				{ "5", "5", "5", "4", "4", "4", "4" }, { "6", "6", "5", "5", "5", "5", "5" },
//				{ "7", "6", "6", "6", "6", "6", "6" }, { "7", "7", "7", "7", "7", "7", "7" } }; // 12?

		String[][] relation = { { "a" } }; // 1
//		String[][] relation = { { "1", "2", "3" }, { "1", "2", "a" }, { "1", "2", "b" } }; // 1
		System.out.println(sol.solution(relation));
	}
}
