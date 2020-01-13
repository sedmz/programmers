import java.util.Arrays;

class Solution {
	public int solution(int[] citations) {
		int totalPaper = citations.length;
		Arrays.sort(citations);

		int idx = totalPaper - 1;
		for (int h = totalPaper; h >= 0; h--)
			while (idx > 0 && citations[idx - 1] >= h) {
				idx--;

			if (citations[idx] >= h && h <= totalPaper - idx) {
				return h;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		// int[] citations = { 350, 452, 877 };
		// int[] citations = { 3, 0, 6, 1, 5 };
		// int[] citations = { 2, 5, 7 };
		// int[] citations = { 8, 7, 7, 6, 5, 5, 3, 0, 0, 0 };
		int[] citations = { 1};
		int n = sol.solution(citations);
		System.out.println(n);
	}
}
