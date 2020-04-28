import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
	public boolean isEqual(String user, String banned) {
		if (user.length() != banned.length())
			return false;

		for (int i = 0; i < banned.length(); i++) {
			if (banned.charAt(i) != '*') {
				if (banned.charAt(i) != user.charAt(i))
					return false;
			}
		}
		return true;
	}

	public int solution(String[] user_id, String[] banned_id) {
		Stack<String> userStack = new Stack<>();
		Stack<Integer> bannedStack = new Stack<>();
		Set<String> answerSet = new HashSet<>();

		userStack.add("01234567".substring(0, user_id.length));
		bannedStack.add(0);

		while (!userStack.isEmpty()) {
			String userIdx = userStack.pop();
			int bannedIdx = bannedStack.pop();
			if (bannedIdx == banned_id.length) {
				answerSet.add("" + userIdx);
				continue;
			}

			for (int i = 0; i < userIdx.length(); i++) {
				String user = user_id[userIdx.charAt(i) - '0'];
				if (isEqual(user, banned_id[bannedIdx])) {
					userStack.add(new StringBuffer(userIdx).replace(i, i + 1, "") + "");
					bannedStack.add(bannedIdx + 1);
				}
			}
		}
		return answerSet.size();
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "abc1**" };
//		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
//		String[] banned_id = { "*rodo", "*rodo", "******" };
//		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
//		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
		sol.solution(user_id, banned_id);
	}
}
