import java.util.Arrays;

class Solution {
	public int getSplitIdx(String query) {
		int diff1 = query.charAt(0) - '?' - 1;

		int i = 0;
		for (; i < query.length(); i++) {
			int diff2 = query.charAt(i) - '?' - 1;
			if (diff1 * diff2 < 0)
				break;
		}
		return i;
	}

	public void sort() {

	}

	public int[] solution(String[] words, String[] queries) {
		
		int[] answer = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			String query = queries[i];
			int idx = getSplitIdx(query);
			for (String word : words) {
				if (word.length() == query.length()) {
					if (word.substring(0, idx).equals(query.substring(0, idx)))
						answer[i]++;
					else if (word.substring(idx).equals(query.substring(idx)))
						answer[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
