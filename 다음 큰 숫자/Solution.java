// Integer.bitCount(int n)을 사용해도 편리함

class Solution {
	public int countOne(int n) {
		int cnt = 0;
		while (n > 0) {
			if (n % 2 == 1)
				cnt++;
			n /= 2;
		}
		return cnt;
	}

	public int solution(int n) {
		int numOfOne = countOne(n);

		while (true) {
			if (countOne(++n) == numOfOne)
				return n;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int answer = sol.solution(78);
		System.out.println(answer);
	}
}
