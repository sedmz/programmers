import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
	public boolean isEqual(String user, String banned) {
		String reg = banned.replace("*", "[\\w\\d]");
		return user.matches(reg);
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
		sol.solution(new String[] { "frodo", "crodo", "abc123" }, new String[] { "*r*d*", "abc1**" });
	}
}
