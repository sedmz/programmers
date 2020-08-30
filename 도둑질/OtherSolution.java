import java.util.Arrays;

class Solution {
	public int solution(int[] money) {
		int[] hasFirst = new int[money.length];
		int[] hasLast = new int[money.length];
		hasFirst[0] = money[0];
		hasFirst[1] = Math.max(money[1], hasFirst[0]);
		hasLast[0] = 0;
		hasLast[1] = money[1];

		for (int i = 2; i < money.length; i++) {
			hasFirst[i] = Math.max(hasFirst[i - 2] + money[i], hasFirst[i - 1]);
			hasLast[i] = Math.max(hasLast[i - 2] + money[i], hasLast[i - 1]);
		}

		return Math.max(hasFirst[hasFirst.length - 2], hasLast[hasLast.length - 1]);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int answer = sol.solution(new int[] { 3, 200, 0, 0, 200, 1 });
		System.out.println(answer);
	}
}
