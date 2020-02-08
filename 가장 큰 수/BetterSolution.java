import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public String solution(int[] numbers) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i] + "");
		}

		Collections.sort(list, (a, b) -> {
			return (b + a).compareTo(a + b);
		});

		String answer = "";
		for (String val : list)
			answer += val;

		if (answer.charAt(0) == '0')
			return "0";
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[] { 3, 30, 34, 5, 9 }));
		System.out.println(sol.solution(new int[] { 0, 0, 0, 0 }));
	}
}
