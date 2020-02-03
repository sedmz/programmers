import java.util.ArrayList;

class Solution {
	public int solution(int n, int[][] costs) {
		int[][] map = new int[n][n];

		for (int[] cost : costs) {
			if (cost.length > 0) {
				map[cost[0]][cost[1]] = cost[2];
				map[cost[1]][cost[0]] = cost[2];
			}
		}

		ArrayList<Integer> connected = new ArrayList<>();
		connected.add(0);

		int sum = 0;
		while (connected.size() < n) {
			int min = -1, i = -1, j = -1;
			
			for (int start : connected) {
				for (int end = 0; end < n; end++) {
					if (!connected.contains(end) && map[start][end] > 0) {
						if (map[start][end] < min || min == -1) {
							min = map[start][end];
							i = start;
							j = end;
						}
					}
				}
			}
			sum += min;
			connected.add(j);
			map[i][j] = 0;
			map[j][i] = 0;
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(2, new int[][] { { 0, 1, 100 } });
		sol.solution(4, new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } });
	}
}
