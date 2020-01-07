class Solution {
	boolean[][] chk;
	int x, y;

	public int getAreaSize(int x, int y, int[][] picture) {
		chk[x][y] = true;
		int color = picture[x][y];
		int size = 1;

		if (x > 0 && picture[x - 1][y] == color)
			if (chk[x - 1][y] == false)
				size += getAreaSize(x - 1, y, picture);
		if (x < chk.length - 1 && picture[x + 1][y] == color)
			if (chk[x + 1][y] == false)
				size += getAreaSize(x + 1, y, picture);
		if (y > 0 && picture[x][y - 1] == color)
			if (chk[x][y - 1] == false)
				size += getAreaSize(x, y - 1, picture);
		if (y < chk[0].length - 1 && picture[x][y + 1] == color)
			if (chk[x][y + 1] == false)
				size += getAreaSize(x, y + 1, picture);

		return size;
	}

	public boolean setStartXY() {
		for (int i = 0; i < chk.length; i++) {
			for (int j = 0; j < chk[i].length; j++) {
				if (chk[i][j] == false) {
					x = i;
					y = j;
					return true;
				}
			}
		}
		return false;
	}

	public void exceptZero(int[][] picture) {
		for (int i = 0; i < chk.length; i++) {
			for (int j = 0; j < chk[0].length; j++) {
				if (picture[i][j] == 0)
					chk[i][j] = true;
			}
		}
	}

	public int[] solution(int m, int n, int[][] picture) {
		chk = new boolean[m][n];
		exceptZero(picture);
		int numOfArea = 0;
		int maxArea = 0;

		while (setStartXY()) {
			numOfArea++;
			int areaSize = getAreaSize(x, y, picture);
			if (areaSize > maxArea)
				maxArea = areaSize;
		}

		return new int[] { numOfArea, maxArea };
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] s = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 }, { 0, 0, 0, 3 } };
		int answer[] = sol.solution(6, 4, s);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}
}
