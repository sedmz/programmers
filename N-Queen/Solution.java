import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	class Queen {
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> dif = new ArrayList<>();
		ArrayList<Integer> sum = new ArrayList<>();
		int y;

		Queen(ArrayList<Integer> x, ArrayList<Integer> dif, ArrayList<Integer> sum, int y) {
			this.x = (ArrayList) x.clone();
			this.dif = (ArrayList) dif.clone();
			this.sum = (ArrayList) sum.clone();
			this.y = y;
		}
	}

	public ArrayList<Integer> clone(ArrayList<Integer> list, int val) {
		ArrayList<Integer> newList = (ArrayList) list.clone();
		newList.add(val);
		return newList;
	}

	public int solution(int n) {
		Queue<Queen> queue = new LinkedList<>();
		queue.add(new Queen(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0));

		int cnt = 0;
		while (!queue.isEmpty()) {
			Queen queen = queue.poll();
			int Y = queen.y + 1;
			if (Y > n) {
				cnt++;
				continue;
			}

			for (int i = 1; i <= n; i++) {
				if (!queen.x.contains(i)) {
					if (!queen.dif.contains(i - Y)) {
						if (!queen.sum.contains(i + Y)) {
							queue.add(new Queen(clone(queen.x, i), clone(queen.dif, i - Y),
									clone(queen.sum, i + Y), Y));
						}
					}
				}
			}
		}
		return cnt;
	}
}
