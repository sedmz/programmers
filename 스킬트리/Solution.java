class Solution {
	public int solution(String skill, String[] skill_trees) {
		char[] arr = skill.toCharArray();

		int cnt = 0;
		for (String tree : skill_trees) {
			boolean isSuccess = true;
			int last, before = -1;
			for (last = arr.length - 1; last >= 0; last--) {
				if (tree.indexOf(arr[last]) != -1)
					break;
			}
			for (int i = 0; i <= last; i++) {
				int idx = tree.indexOf(arr[i]);

				if (before >= idx) {
					isSuccess = false;
					break;
				}
				before = idx;
			}
			if (isSuccess == true) {
				System.out.println(tree);
				cnt++;
			}
		}
		return cnt;
	}
}
