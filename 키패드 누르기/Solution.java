class Solution {
	public StringBuffer sb = new StringBuffer("");
	public int[] x = { 1, 0, 1, 2, 0, 1, 2, 0, 1, 2 };
	public int[] y = { 3, 0, 0, 0, 1, 1, 1, 2, 2, 2 };
	public int leftX = 0, leftY = 3, left;
	public int rightX = 2, rightY = 3, right;

	public String solution(int[] numbers, String hand) {
		for (int n : numbers) {
			switch (x[n]) {
			case 0:
				moveLeft(n);
				break;
			case 2:
				moveRight(n);
				break;
			default:
				setDistance(n);

				if (left == right) {
					if (hand.equals("left")) {
						moveLeft(n);
					} else {
						moveRight(n);
					}
				} else if (left > right) {
					moveRight(n);
				} else {
					moveLeft(n);
				}
			}
		}
		return sb.toString();
	}

	public void moveLeft(int n) {
		sb.append("L");
		leftX = x[n];
		leftY = y[n];
	}

	public void moveRight(int n) {
		sb.append("R");
		rightX = x[n];
		rightY = y[n];
	}

	public void setDistance(int n) {
		left =  Math.abs(leftX - x[n]) + Math.abs(leftY - y[n]);
		right =  Math.abs(rightX - x[n]) + Math.abs(rightY - y[n]);
	}
}
