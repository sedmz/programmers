import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
	public int[] solution(int[] numbers) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}

		return Arrays.stream(set.toArray(new Integer[0])).mapToInt(Integer::intValue).sorted().toArray();
	}
}
