import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
	boolean[][] up, right;
	int N;

	public boolean isInstallableUp(int i, int j) {
		if (i == 0)
			return true;
		else if (i > 0 && up[i - 1][j])
			return true;
		else if (right[i][j])
			return true;
		else if (j > 0 && right[i][j - 1])
			return true;
		return false;
	}

	public boolean isInstallableRight(int i, int j) {
		if (i > 0 && up[i - 1][j]) {
			return true;
		} else if (i > 0 && j + 1 < N && up[i - 1][j + 1]) {
			return true;
		} else if (j > 0 && j + 1 < N && right[i][j - 1] && right[i][j + 1]) {
			return true;
		}
		return false;
	}

	public int[][] solution(int n, int[][] build_frame) {
		N = n + 1;
		up = new boolean[N][N];
		right = new boolean[N][N];

		for (int[] frame : build_frame) {
			int i = frame[1];
			int j = frame[0];

			if (frame[2] == 0) {
				if (frame[3] == 1) {
					up[i][j] = isInstallableUp(i, j);
				} else {
					up[i][j] = false;
					if (i + 1 < N && up[i + 1][j] && !isInstallableUp(i + 1, j)) {
						up[i][j] = true;
					} else if (i + 1 < N && right[i + 1][j] && !isInstallableRight(i + 1, j)) {
						up[i][j] = true;
					} else if (i + 1 < N && j > 0 && right[i + 1][j - 1] && !isInstallableRight(i + 1, j - 1)) {
						up[i][j] = true;
					}
				}
			} else {
				if (frame[3] == 1) {
					right[i][j] = isInstallableRight(i, j);
				} else {
					right[i][j] = false;
					if (up[i][j] && !isInstallableUp(i, j)) {
						right[i][j] = true;
					} else if (j + 1 < N && up[i][j + 1] && !isInstallableUp(i, j + 1)) {
						right[i][j] = true;
					} else if (j > 0 && right[i][j - 1] && !isInstallableRight(i, j - 1)) {
						right[i][j] = true;
					} else if (j + 1 < N && right[i][j + 1] && !isInstallableRight(i, j + 1)) {
						right[i][j] = true;
					}
				}
			}
		}
		return getAnswer();
	}

	public int[][] sort(int[][] answer) {
		Arrays.sort(answer, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					if (o1[1] == o2[1]) {
						return ((Comparable) o1[2]).compareTo(o2[2]);
					}
					return ((Comparable) o1[1]).compareTo(o2[1]);
				}
				return ((Comparable) o1[0]).compareTo(o2[0]);
			}
		});
		return answer;
	}

	public int[][] getAnswer() {
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < up.length; i++) {
			for (int j = 0; j < up[i].length; j++) {
				if (up[i][j] == true)
					list.add(new int[] { j, i, 0 });
				if (right[i][j] == true)
					list.add(new int[] { j, i, 1 });
			}
		}

		int answer[][] = new int[list.size()][3];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return sort(answer);
	}
}
