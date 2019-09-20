import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		int[] days = new int[progresses.length];
		int size = 0;

		for (int i = 0; i < days.length; i++) {
			days[i] = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
			if (i > 0) {
				if (days[i - 1] > days[i]) {
					days[i] = days[i - 1];
				}
			}
			map.put(days[i], map.getOrDefault(days[i], 0) + 1);
			if (map.get(days[i]) == 1)
				size++;
		}

		Set<Integer> key = map.keySet();
		Iterator<Integer> it = key.iterator();
		int[] answer = new int[size];
		for (int i = 0; i < answer.length; i++)
			answer[i] = map.get(it.next());
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 });
	}
}
