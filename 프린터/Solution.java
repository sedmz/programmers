class Solution {
	public int solution(int[] priorities, int location) {
		int index = 0;

		int i = 0;
		while (index < priorities.length) {
			if (getMaxPriority(priorities) == priorities[i]) {
				index++;
				priorities[i] = -1;

				if (i == location) {
					return index;
				}
			}

			i = (i + 1) % priorities.length;
		}
		return -1;
	}

	public static int getMaxPriority(int[] priorities) {
		int max = -1;
		for (int priority : priorities)
			if (priority > max)
				max = priority;

		return max;
	}
}
