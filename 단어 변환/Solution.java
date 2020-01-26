class Solution {
	static String target;
	static String[] words;
	static final int MAX_SIZE = 50;
	static int minCnt = MAX_SIZE;

	public int solution(String begin, String target, String[] words) {
		boolean[] visited = new boolean[words.length];
		this.target = target;
		this.words = words;

		for (int idx = 0; idx < words.length; idx++) {
			if (isConvertable(begin, words[idx])) {
				DFS(idx, 1, visited);
			}
		}

		if (minCnt == MAX_SIZE)
			return 0;
		return minCnt;
	}

	public static boolean[] copyArray(boolean[] array) {
		boolean[] copyArray = new boolean[array.length];
		for (int i = 0; i < array.length; i++)
			copyArray[i] = array[i];
		return copyArray;
	}

	public static boolean isConvertable(String beginWord, String targetWord) {
		int cnt = 0;
		for (int i = 0; i < beginWord.length(); i++) {
			if (beginWord.charAt(i) != targetWord.charAt(i)) {
				if (++cnt > 1) {
					return false;
				}
			}
		}
		if (cnt == 0)
			return false;
		return true;
	}

	public static void DFS(int idx, int cnt, boolean[] visited) {
		if (words[idx].contentEquals(target)) {
			minCnt = Math.min(cnt, minCnt);
		}

		visited[idx] = true;
		for (int j = 0; j < words.length; j++) {
			if (!visited[j]) {
				if (isConvertable(words[idx], words[j])) {
					DFS(j, cnt + 1, copyArray(visited));
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		String begin = "hit";
		String target = "cog";
		String words[] = { "hot", "dot", "dog", "lot", "log", "cog" };
		// String words[] = { "hot", "dot", "dog", "lot", "log" };
		System.out.println(sol.solution(begin, target, words)); 
	}
}
