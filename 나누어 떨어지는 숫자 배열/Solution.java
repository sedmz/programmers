import java.util.Arrays;
import java.util.Vector;

class Solution {
	public int[] solution(int[] arr, int divisor) {
		Vector<Integer> v = new Vector<Integer>();

		for (int value : arr) {
			if (value % divisor == 0)
				v.add(value);
		}

		if (v.size() == 0) {
			int[] answer = { -1 };
			return answer;
		} else {
			int[] answer = new int[v.size()];
			for (int i = 0; i < v.size(); i++)
				answer[i] = v.get(i);

			Arrays.sort(answer);

			return answer;
		}
	}
}
