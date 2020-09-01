import java.util.Arrays;

class Solution {
	public int compare(String target, String compare) {
		target += " ";
		compare += " ";

		int i = 0;
		while (target.charAt(i) == compare.charAt(i)) {
			i++;
		}
		return target.length() - 1 == i ? i : i + 1;
	}

	public int solution(String[] words) {
		Arrays.sort(words);

		int cnt = 0;
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String before = i > 0 ? words[i - 1] : "";
			String after = i < words.length - 1 ? words[i + 1] : "";

			cnt += Math.max(compare(word, before), compare(word, after));
		}
		return cnt;
	}
}
