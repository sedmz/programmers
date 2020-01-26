import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
	public boolean isContinue(Stack<Integer> list, boolean[] visit) {
		for (int i = 0; i < list.size(); i++) {
			if (visit[list.get(i)] == true)
				return false;
		}
		return true;
	}

	public boolean isUnique(Stack<Integer> list, String[][] relation) {
		HashSet<String> set = new HashSet<String>();

		for (int j = 0; j < relation.length; j++) {
			String str = "";
			for (int i = 0; i < list.size(); i++) {
				str += relation[j][list.get(i)] + " ";
			}
			set.add(str);
		}
		return set.size() == relation.length;
	}

	public int solution(String[][] relation) {
		Queue<Stack<Integer>> queue = new LinkedList<>();
		boolean[] visited = new boolean[relation[0].length];
		boolean[] unvisitable = new boolean[relation[0].length];
		int answer = 0, size = 0;

		for (int idx = 0; idx < relation[0].length; idx++)
			queue.add(addStack(new Stack<Integer>(), idx));

		while (!queue.isEmpty()) {
			// System.out.println(queue);
			Stack<Integer> list = queue.poll();

			if (list.size() > size) {
				unvisitable = copyArray(visited);
				size = list.size();
			}

			if (!isContinue(list, unvisitable)) {
				// System.out.println("continue");
				continue;
			}

			if (isUnique(list, relation)) {
				for (int i = 0; i < list.size(); i++)
					visited[list.get(i)] = true;
				System.out.println("통과한 list" + " " + list);
				answer++;
			} else {
				for (int i = list.peek() + 1; i < visited.length; i++) {
					if (visited[i] == false) {
						queue.add(addStack(list, i));
					}
				}
			}
		}
		return answer;
	}

	public Stack<Integer> addStack(Stack<Integer> list, int i) {
		Stack<Integer> newArray = new Stack<>();
		for (int idx = 0; idx < list.size(); idx++) {
			newArray.add(list.get(idx));
		}
		newArray.add(i);
		return newArray;
	}

	public boolean[] copyArray(boolean[] visit) {
		boolean[] newArray = new boolean[visit.length];
		for (int idx = 0; idx < visit.length; idx++) {
			newArray[idx] = visit[idx];
		}
		return newArray;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();

//		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
//				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
//				{ "600", "apeach", "music", "2" } };

//		  String[][] relation = { { "100", "music", "2" }, { "200", "math", "2" }, {
//		  "300", "computer", "3" }, { "400", "computer", "4" }, { "500", "music", "3"
//		  }, { "600", "music", "2" } }; // 1

		/*
		 * String[][] relation = { { "200", "ryan", "music", "2" }, { "200", "apeach",
		 * "math", "2" }, { "300", "tube", "computer", "3" }, { "400", "con",
		 * "computer", "4" }, { "500", "muzi", "music", "3" }, { "600", "apeach",
		 * "music", "2" } }; // 3
		 */

//		String[][] relation = { { "a", "b", "c", "d", "e", "f", "g", "1" }, { "a", "b", "c", "d", "e", "f", "g", "2" },
//				{ "a", "b", "c", "d", "e", "f", "g", "3" }, { "a", "b", "c", "d", "e", "f", "g", "4" },
//				{ "a", "b", "c", "d", "e", "f", "g", "5" }, { "a", "b", "c", "d", "e", "f", "g", "6" },
//				{ "a", "b", "c", "d", "e", "f", "g", "7" }, { "a", "b", "c", "d", "e", "f", "g", "8" },
//				{ "a", "b", "c", "d", "e", "f", "g", "9" }, { "a", "b", "c", "d", "e", "f", "g", "10" },
//				{ "a", "b", "c", "d", "e", "f", "g", "11" }, { "a", "b", "c", "d", "e", "f", "g", "12" },
//				{ "a", "b", "c", "d", "e", "f", "g", "13" }, { "a", "b", "c", "d", "e", "f", "g", "14" },
//				{ "a", "b", "c", "d", "e", "f", "g", "15" }, { "a", "b", "c", "d", "e", "f", "g", "16" },
//				{ "a", "b", "c", "d", "e", "f", "g", "17" }, { "a", "b", "c", "d", "e", "f", "g", "18" },
//				{ "a", "b", "c", "d", "e", "f", "g", "19" }, { "a", "b", "c", "d", "e", "f", "g", "20" } }; //1

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
//				{ "1", "0", "1", "1", "1", "1", "1", "1" }, { "0", "1", "1", "1", "1", "1", "1", "1" } };
//		String[][] relation = { { "1", "1", "1", "1", "1", "1", "1", "0" }, { "1", "1", "1", "1", "1", "1", "0", "1" },
//				{ "1", "1", "1", "1", "1", "0", "1", "1" }, { "1", "1", "1", "1", "0", "1", "1", "1" },
//				{ "1", "1", "1", "0", "1", "1", "1", "1" }, { "1", "1", "0", "1", "1", "1", "1", "1" },
//				{ "1", "0", "1", "1", "1", "1", "1", "1" } };

		String[][] relation = { { "1", "1", "1", "1", "1", "1", "1" }, { "2", "2", "2", "2", "2", "0", "0" },
				{ "3", "3", "3", "3", "3", "2", "2" }, { "4", "4", "4", "4", "3", "3", "3" },
				{ "5", "5", "5", "4", "4", "4", "4" }, { "6", "6", "5", "5", "5", "5", "5" },
				{ "7", "6", "6", "6", "6", "6", "6" }, { "7", "7", "7", "7", "7", "7", "7" } };

		// String[][] relation = { { "a" } };
//		String[][] relation = { { "1", "2", "3" }, { "1", "2", "a" }, { "1", "2", "b" } };
		System.out.println(sol.solution(relation));
	}
}
