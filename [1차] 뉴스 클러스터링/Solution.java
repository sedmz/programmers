import java.util.ArrayList;

class Solution {
	ArrayList<String> difference1 = new ArrayList<>();
	ArrayList<String> difference2 = new ArrayList<>();
	ArrayList<String> intersection = new ArrayList<>();

	public void setSet(String str1, String str2) {
		for (int i = 0; i < str1.length() - 1; i++) {
			if (Character.isAlphabetic(str1.charAt(i))) {
				if (Character.isAlphabetic(str1.charAt(i + 1))) {
					difference1.add(str1.substring(i, i + 2).toUpperCase());
				}
			}
		}
		for (int i = 0; i < str2.length() - 1; i++) {
			if (Character.isAlphabetic(str2.charAt(i))) {
				if (Character.isAlphabetic(str2.charAt(i + 1))) {
					String tmp = str2.substring(i, i + 2).toUpperCase();
					if (difference1.contains(tmp)) {
						difference1.remove(tmp);
						intersection.add(tmp);
					} else {
						difference2.add(tmp);
					}
				}
			}
		}

	}

	public int calculate() {
		if (difference1.size() == 0)
			if (difference2.size() == 0)
				if (intersection.size() == 0)
					return 1 * 65536;

		int interSize = intersection.size();
		int diffSize = difference1.size() + difference2.size();
		double rate = interSize / (double) (diffSize + interSize);
		return (int) (rate * 65536);
	}

	public int solution(String str1, String str2) {
		setSet(str1, str2);
		return calculate();
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		String str1 = "FRANCE";
		String str2 = "french";
		// String str1 = "aa1+aa2";
		// String str2 = "AAAA12";
		// String str1 = "AAAAAAAAAA";
		// String str2 = "CCCCCCCCCC";
		int answer = sol.solution(str1, str2);
		System.out.println(sol.difference1 + " " + sol.difference2);
		System.out.println(sol.intersection);
		System.out.println(answer);
	}
}
