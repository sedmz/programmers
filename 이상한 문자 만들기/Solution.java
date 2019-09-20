class Solution {
	public String solution(String s) {
		String answer = "";

		String[] words = s.split(" ");
		for (int j = 0; j < words.length; j++) {
			String word = words[j];
			for (int i = 0; i < word.length(); i++) {
				if (i % 2 == 0)
					answer += word.substring(i, i + 1).toUpperCase();
				else if (i % 2 == 1)
					answer += word.substring(i, i + 1).toLowerCase();
			}
			if (j < words.length - 1)
				answer += " ";
		}
		return answer;
	}
}
