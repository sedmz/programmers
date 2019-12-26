mport java.util.Stack;

class Solution {
	public String solution(int n, int t, int m, int p) {
		Stack<Integer> stack = new Stack<>();
		char numerialSystem[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		int limit = m * t, number = 0, numberCopied = number;

		String sequence = "";
		while (sequence.length() < limit) {
			if (numberCopied < n) {
				sequence += numerialSystem[numberCopied];
				numberCopied = ++number;
				while (!stack.isEmpty())
					sequence += numerialSystem[stack.pop()];
			} else {
				stack.push(numberCopied % n);
				numberCopied /= n;
			}
		}

		String result = "";
		for (int i = p - 1; result.length() < t; i = i + m)
			result += sequence.charAt(i);

		return result;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		String result = sol.solution(16, 1000, 100, 100);
		System.out.println(result);
	}
}
