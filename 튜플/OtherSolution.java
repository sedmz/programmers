import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;

class Solution {
	public int[] solution(String s) {
		LinkedHashSet<Integer> set = new LinkedHashSet<>();

		String[] tuples = s.substring(2, s.length() - 2).split("},\\{");
		Arrays.sort(tuples, new Comparator<String>() {
			public int compare(String a, String b) {
				return Integer.compare(a.length(), b.length());
			}
		});
		
		for (String tuple : tuples) {
			for (String t : tuple.split(",")) {
				set.add(Integer.parseInt(t));
			}
		}

		ArrayList<Integer> answer = new ArrayList<>();
		answer.addAll(set);

		return answer.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
	}
}
