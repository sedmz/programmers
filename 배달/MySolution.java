import java.util.*;

class Solution {
	public int solution(int N, int[][] road, int K) {
		int[][] distance = new int[N][N];
		for (int i = 0; i < distance.length; i++) {
			Arrays.fill(distance[i], 500000);
			distance[i][i] = 0;
		}

		for (int[] r : road) {
			distance[r[0] - 1][r[1] - 1] = Math.min(r[2], distance[r[0] - 1][r[1] - 1]);
			distance[r[1] - 1][r[0] - 1] = Math.min(r[2], distance[r[1] - 1][r[0] - 1]);
		}
		
		for (int k = 0; k < distance.length; k++) {
			for (int i = 0; i < distance.length; i++) {
				for (int j = 0; j < distance.length; j++) {
					distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
				}
			}
		}

		int cnt = 0;
		for (int d : distance[0]) {
			if (d <= K)
				cnt++;
		}
		return cnt;
	}
}
