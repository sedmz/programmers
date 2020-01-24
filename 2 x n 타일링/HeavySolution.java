class Solution {
	public int[] getXY(boolean[][] square, int x, int y) {
		for (int i = x; i < square.length; i++) {
			for (int j = y; j < square[i].length; j++) {
				if (square[i][j] == false) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] {};
	}

	public boolean[][] copy(boolean[][] array) {
		boolean[][] newArray = new boolean[array.length][array[0].length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				newArray[i][j] = array[i][j];
			}
		}
		return newArray;
	}

	public int dfs(boolean[][] square, int x, int y, String block) {
		if (block.contentEquals("세로")) {
			square[x][y] = true;
			square[x + 1][y] = true;
		} else {
			square[x][y] = true;
			square[x][y + 1] = true;
		}

		int[] xy = getXY(square, x, y);
		if (xy.length == 0) {
			return 1;
		} else if (xy[0] + 1 >= square.length && xy[1] + 1 > square[0].length) {
			return 0;
		} else if (xy[0] + 1 >= square.length) {
			return dfs(copy(square), xy[0], xy[1], "가로");
		} else if (xy[1] + 1 >= square[0].length) {
			return dfs(copy(square), xy[0], xy[1], "세로");
		} else {
			return dfs(copy(square), xy[0], xy[1], "가로") + dfs(copy(square), xy[0], xy[1], "세로");
		}
	}

	public int solution(int n) {
		boolean square[][] = new boolean[2][n];
		return dfs(copy(square), 0, 0, "가로") + dfs(copy(square), 0, 0, "세로");
	}
}
