import java.util.Arrays;

class Solution {
	public boolean[][] setPassable(boolean[][] passable, int[][] puddles) {
		for (int i = 0; i < passable.length; i++) {
			Arrays.fill(passable[i], true);
		}

		for (int[] coordinate : puddles) {
			passable[coordinate[1] - 1][coordinate[0] - 1] = false;
		}

		return passable;
	}

	public int[][] setRoute(int[][] route, boolean[][] passable) {
		for (int i = 1; i < route.length; i++) {
			if (passable[i][0] == true)
				route[i][0] = 1;
			else
				break;
		}

		for (int i = 1; i < route[0].length; i++) {
			if (passable[0][i] == true)
				route[0][i] = 1;
			else
				break;
		}

		for (int i = 1; i < route.length; i++) {
			for (int j = 1; j < route[i].length; j++) {
				if (passable[i][j] == true) {
					route[i][j] = (route[i - 1][j] + route[i][j - 1]) % 1000000007;
				}
			}
		}
		return route;
	}

	public int solution(int m, int n, int[][] puddles) {
		int route[][] = new int[n][m];
		boolean passable[][] = new boolean[n][m];

		passable = setPassable(passable, puddles);
		route = setRoute(route, passable);
		return route[n - 1][m - 1];
	}
  
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(4, 3, new int[][] { { 2, 2 }, { 3, 2 } });
		// sol.solution(3, 3, new int[][] { { 1, 2 }, { 2, 2 } });
		// sol.solution(2, 4, new int[][] { { 2, 1 }, { 2, 2 }, { 2, 3 }, { 1, 4 } });
	}
}
