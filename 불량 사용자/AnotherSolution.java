import java.util.*;

class Solution {
	boolean[] visited;
	ArrayList<String[]> list = new ArrayList<>();
	String[] user_id, banned_id;

	public void init(String[] user_id, String[] banned_id) {
		this.user_id = user_id;
		this.banned_id = banned_id;
		visited = new boolean[user_id.length];
	}

	public int solution(String[] user_id, String[] banned_id) {
		init(user_id, banned_id);
		dfs(0);
		return list.size();
	}

	public String[] compressVisit() {
		String[] arr = new String[banned_id.length];

		for (int i = 0, j = 0; i < visited.length; i++) {
			if (visited[i])
				arr[j++] = user_id[i];
		}
		return arr;
	}

	public void dfs(int bannedIdx) {
		if (bannedIdx == banned_id.length) {
			String[] arr = compressVisit();
			if (!isExist(arr))
				list.add(arr);
		} else {
			for (int userIdx = 0; userIdx < user_id.length; userIdx++) {
				if (!visited[userIdx]) {
					/********** 주목 ***********/
					if (isEqual(user_id[userIdx], banned_id[bannedIdx])) {
						visited[userIdx] = true;
						dfs(bannedIdx + 1);
						visited[userIdx] = false;
					}
					/*************************/
				}
			}
		}
	}

	public boolean isExist(String[] arr) {
		for (String[] tmp : list) {
			for (int j = 0; j <= tmp.length; j++) {
				if (j == tmp.length)
					return true;
				else if (tmp[j] != arr[j]) {
					break;
				}
			}
		}
		return false;
	}

	public boolean isEqual(String user, String banned) {
		if (user.length() != banned.length())
			return false;

		for (int j = 0; j < user.length(); j++) {
			if (user.charAt(j) != banned.charAt(j) && banned.charAt(j) != '*')
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(new String[] { "frodo", "crodo", "abc123" }, new String[] { "*r*d*", "abc1**" });
	}
}
