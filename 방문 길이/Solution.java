import java.util.HashSet;
import java.util.Set;

class Solution {
	final static int UP_MARGIN = 5;
	final static int DOWN_MARGIN = -5;
	final static int RIGHT_MARGIN = 5;
	final static int LEFT_MARGIN = -5;

	class XY {
		int x1, y1, x2, y2;

		public XY(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		public String toString() {
//			return x1+" "+y1+" ~ "+x2+" "+y2;
			return x2 + " " + y2;
		}

		@Override
		public int hashCode() {
			return (Math.min(x1, x2) + "" + Math.min(y1, y2) + "" + Math.max(x1, x2) + "" + Math.max(y1, y2))
					.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			XY xy = (XY) obj;
			if (x1 == xy.x1 && y1 == xy.y1) {
				if (x2 == xy.x2 && y2 == xy.y2) {
					return true;
				}
			}
			if (x1 == xy.x2 && y1 == xy.y2) {
				if (x2 == xy.x1 && y2 == xy.y1) {
					return true;
				}
			}
			return false;
		}
	}

	public int solution(String dirs) {
		Set<XY> set = new HashSet<>();
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

		char[] charArray = dirs.toCharArray();
		for (char ch : charArray) {
			switch (ch) {
			case 'U':
				x2 = x1;
				y2 = y1 + 1;
				break;
			case 'D':
				x2 = x1;
				y2 = y1 - 1;
				break;
			case 'R':
				x2 = x1 + 1;
				y2 = y1;
				break;
			case 'L':
				x2 = x1 - 1;
				y2 = y1;
				break;
			}
			if (LEFT_MARGIN <= x2 && x2 <= RIGHT_MARGIN) {
				if (DOWN_MARGIN <= y2 && y2 <= UP_MARGIN) {
					set.add(new XY(x1, y1, x2, y2));
					x1 = x2;
					y1 = y2;
				}
			}
		}
		return set.size();
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int answer = sol.solution("ULURRDLLU");
		System.out.println(answer);
	}
}
