class Solution {
	public int solution(int n, int a, int b) {
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < n; i++)
			sb = sb.append("x");
		sb = sb.replace(a - 1, a, "o");
		sb = sb.replace(b - 1, b, "o");

		int cnt = 0;
		while (true) {
			cnt++;
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == 'o' && sb.charAt(i + 1) == 'o')
					return cnt;
				else if (sb.charAt(i) == 'o' || sb.charAt(i + 1) == 'o')
					sb.replace(i, i + 2, "o");
				else
					sb.replace(i, i + 2, "x");
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 8;
		int a = 1;
		int b = 7;
		System.out.println(sol.solution(n, a, b));
	}
}
