class Solution {
	public String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];
		for (int i = 0; i < strings.length - 1; i++) {
			for (int j = i + 1; j < strings.length; j++) {
				if (strings[i].compareTo(strings[j]) > 0) {
					String tmp = strings[i];
					strings[i] = strings[j];
					strings[j] = tmp;
				}
			}
		}
		
		int idx = -1;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			for (String string : strings) {
				if (string.charAt(n) == ch)
					answer[++idx] = string;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 1;
		String strings[] = { "sun", "bed", "car" };
		sol.solution(strings, n);
	}
}
