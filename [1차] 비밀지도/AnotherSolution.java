package programmers;

class Solution {
	public String makeSharp(int n, int m) {
		if (n == 0) {
			if (m > 0) {
				String str = "";
				for (int i = 0; i < m; i++) {
					str += " ";
				}
				return str;
			} else
				return "";
		} else {
			return n % 2 == 0 ? makeSharp(n / 2, m - 1) + " " : makeSharp(n / 2, m - 1) + "#";
		}
	}

	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		int[] secretMap = new int[n];
		for (int i = 0; i < n; i++) {
			secretMap[i] = arr1[i] | arr2[i];
			answer[i] = makeSharp(secretMap[i], n);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 5;
		int arr1[] = { 9, 20, 28, 18, 11 };
		int arr2[] = { 30, 1, 21, 17, 28 };
		String result[] = sol.solution(n, arr1, arr2);
		for (String str : result)
			System.out.println(str);
	}
}
