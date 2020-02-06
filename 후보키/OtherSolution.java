import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	private boolean isPossible(List<Integer> list, int val) {
		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i) & val) == list.get(i))
				return false;
		}
		return true;
	}

	public int solution(String[][] relation) {
		List<Integer> list = new ArrayList<Integer>();
		int numOfBundles = 1 << relation[0].length;

		for (int bundle = 1; bundle < numOfBundles; bundle++) {
			Set<String> set = new HashSet<String>();
			for (int i = 0; i < relation.length; i++) {
				String string = "";
				for (int j = 0; j < relation[0].length; j++) {
					if ((bundle & (1 << j)) > 0) {
						string += relation[i][j];
					}
				}
				set.add(string);
			}
			if (set.size() == relation.length && isPossible(list, bundle)) {
				list.add(bundle);
			}
		}
		return list.size();
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[][] relation = { { "a" } }; // 1
		System.out.println(sol.solution(relation));
	}
}
