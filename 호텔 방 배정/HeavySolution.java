import java.util.ArrayList;

class Solution {
	ArrayList<long[]> ranges = new ArrayList<>();
	long[] room_number;

	public int setRoomNumber(int i) {
		long num = room_number[i];
		for (int idx = 0; idx < ranges.size(); idx++) {
			long[] range = ranges.get(idx);
			if (range[0] <= num && range[1] >= num) {
				room_number[i] = range[1]++;
				ranges.set(idx, range);
				return idx;
			}
		}

		long[] range = { num, num + 1 };
		int idx = getAddIdx(range);
		ranges.add(idx, range);
		return idx;
	}

	public int getAddIdx(long[] range) {
		for (int i = 0; i < ranges.size(); i++) {
			if (ranges.get(i)[0] >= range[1])
				return i;
		}
		return ranges.size();
	}

	public void merge(int i) {
		long[] range = ranges.get(i);
		if (i < ranges.size() - 1) {
			long[] nextRange = ranges.get(i + 1);
			if (range[1] == nextRange[0]) {
				range[1] = nextRange[1];
				ranges.set(i, range);
				ranges.remove(i + 1);
			}
		}
	}

	public long[] solution(long k, long[] room_number) {
		this.room_number = room_number;

		for (int i = 0; i < room_number.length; i++) {
			int recentIdx = setRoomNumber(i);
			merge(recentIdx);
		}
		return room_number;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(10, new long[] { 5, 5, 3, 3, 2, 1, 1 });
	}
}
