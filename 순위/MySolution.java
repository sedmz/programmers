import java.util.HashSet;
import java.util.Set;

class Solution {
	public int solution(int n, int[][] results) {
		Set<Integer>[] win = new HashSet[n + 1];
		Set<Integer>[] lose = new HashSet[n + 1];

		for (int i = 1; i < win.length; i++) {
			win[i] = new HashSet<>();
			lose[i] = new HashSet<>();

			win[i].add(i);
			lose[i].add(i);
		}

		for (int[] result : results) {
			int winner = result[0];
			int loser = result[1];

			win[loser].addAll(win[winner]);
			for (int loserOfLoser : lose[loser]) {
				win[loserOfLoser].addAll(win[winner]);
			}

			lose[winner].addAll(lose[loser]);
			for (int winnerOfWinner : win[winner]) {
				lose[winnerOfWinner].addAll(lose[loser]);
			}
		}

		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (win[i].size() + lose[i].size() == n + 1)
				answer++;
		}

		return answer;
	}
}
