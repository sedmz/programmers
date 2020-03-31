class Solution {
	public int solution(String s) {
		int start = 0, size = s.length();

		while (true) {
			if (isRight(s, start, size))
				return size;

			if (++start + size > s.length()) {
				start = 0;
				size--;
			}
		}
	}

	public boolean isRight(String s, int start, int size) {
		for (int i = 0; i < Math.ceil(size / 2.0); i++) {
			if (s.charAt(start + i) != s.charAt(start + size - 1 - i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("abcdefghijklmnopqrstuvwxyz"));
	}
}
