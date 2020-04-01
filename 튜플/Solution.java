import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
	public int[] sortByValue(HashMap<Integer, Integer> map) {
		Integer[] arr = map.keySet().toArray(new Integer[map.size()]);

		Arrays.sort(arr, new Comparator() {
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);

				return ((Comparable) v2).compareTo(v1);
			}
		});

		return Arrays.stream(arr).mapToInt(i -> i).toArray();
	}

	public int[] solution(String s) {
		s = s.substring(2, s.length() - 2).replace("},{", ",");

		HashMap<Integer, Integer> map = new HashMap<>();
		for (String str : s.split(",")) {
			int n = Integer.parseInt(str);
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		return sortByValue(map);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
	}
}
