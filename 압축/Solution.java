import java.util.*;

class Solution {
	HashMap<String, Integer> map = new HashMap<>();
	ArrayList<Integer> list = new ArrayList<>();
	int idx, mapSize = 26;

	public String getW(String msg) {
		for (int i = msg.length() - idx; i > 0; i--) {
			String substr = msg.substring(idx, idx + i);
			if (map.getOrDefault(substr, -1) != -1) {
				idx = idx + i;
				return substr;
			}
		}
		return "";
	}

	public int[] listToArray(ArrayList<Integer> list) {
		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++)
			result[i] = list.get(i);
		return result;
	}

	public int[] LZW(String msg) {
		for (idx = 0; idx < msg.length();) {
			String substr = getW(msg);
			list.add(map.get(substr));

			if (idx < msg.length()) {
				String input = substr + msg.substring(idx, idx + 1);
				map.put(input, ++mapSize);
			}
		}
		return listToArray(list);
	}

	public int[] solution(String msg) {
		for (char ch = 'A'; ch <= 'Z'; ch++)
			map.put(ch + "", (int) ch - '@');

		int[] result = LZW(msg);
		return result;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution("KAKAO");
		/* sol.solution("TOBEORNOTTOBEORTOBEORNOT"); */
		/* sol.solution("ABABABABABABABAB"); */
	}
}
