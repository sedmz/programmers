public class Solution {
	static String arr[] = new String[1000];

	public int solution(int[][] baseball) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				for (int k = 1; k <= 9; k++) {
					if (i == j || j == k || k == i)
						continue;
					int n = i * 100 + j * 10 + k;
					arr[n] = "" + n;
				}
			}
		}

		for (int line = 0; line < baseball.length; line++) {
			int num = baseball[line][0];
			int strike = baseball[line][1];
			int ball = baseball[line][2];
			checkNum("" + num, strike, ball);
		}

		int answer = 0;
		for (int i = 0; i < 1000; i++)
			if (arr[i] != null)
				answer++;
		System.out.println(answer);
		return answer;
	}

	public static void checkNum(String num, int strike, int ball) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null)
				continue;

			if (getStrike(num, arr[i]) != strike)
				arr[i] = null;
			else if (getBall(num, arr[i]) != ball) {
				arr[i] = null;
			}

		}
	}

	public static int getStrike(String n1, String n2) {
		int strikeCount = 0;

		if (n1.charAt(0) == n2.charAt(0))
			strikeCount++;
		if (n1.charAt(1) == n2.charAt(1))
			strikeCount++;
		if (n1.charAt(2) == n2.charAt(2))
			strikeCount++;

		return strikeCount;
	}

	public static int getBall(String n1, String n2) {
		int ballCount = 0;

		if (n2.indexOf(n1.charAt(0)) != -1)
			if (n2.indexOf(n1.charAt(0)) != 0)
				ballCount++;
		if (n2.indexOf(n1.charAt(1)) != -1)
			if (n2.indexOf(n1.charAt(1)) != 1)
				ballCount++;
		if (n2.indexOf(n1.charAt(2)) != -1)
			if (n2.indexOf(n1.charAt(2)) != 2)
				ballCount++;

		return ballCount;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(new int[][] { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } });
	}
}
