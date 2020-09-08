class Solution {
	public int[][] spinKey(int[][] key) {
		int M = key.length;

		int[][] spinned = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				spinned[i][j] = key[j][M - i - 1];
			}
		}
		return spinned;
	}

	public boolean compare(int[][] key, int[][] lock, int I, int J) {
		int M = key.length, N = lock.length;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int keyValue = i + I < M && i + I >= 0 && j + J < M && j + J >= 0 ? key[i + I][j + J] : 0;

				if (keyValue + lock[i][j] != 1) {
					return false;
				}
			}
		}
		return true;

	}

	public boolean move(int[][] key, int[][] lock) {
		int M = lock.length;

		for (int I = M - 1; I >= M * -1 -1; I--) {
			for (int J = M - 1; J >= M * -1 -1; J--) {
				if (compare(key, lock, I, J)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean solution(int[][] key, int[][] lock) {
		for (int i = 0; i < 4; i++) {
			if (move(key, lock)) {
				return true;
			}
			key = spinKey(key);
		}
		return false;
	}
}
