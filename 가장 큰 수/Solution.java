import java.util.PriorityQueue;

class Solution {
	class NewString implements Comparable<NewString> {
		String number;

		public NewString(int number) {
			this.number = Integer.toString(number);
		}

		@Override
		public int compareTo(NewString target) {
			String a = target.number + number;
			String b = number + target.number;
			return a.compareTo(b);
		}

		public String toString() {
			return number;
		}
	}

	public String solution(int[] numbers) {
		PriorityQueue<NewString> queue = new PriorityQueue<>();
		for (int number : numbers) {
			queue.add(new NewString(number));
		}

		String answer = "";
		while (!queue.isEmpty())
			answer += queue.poll();

		if (answer.charAt(0) == '0')
			return "0";
		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[] { 3, 30, 34, 5, 9 }));
		System.out.println(sol.solution(new int[] { 30, 34, 5, 9, 3, 33, 2 }));
		System.out.println(sol.solution(new int[] { 1, 2, 3, 4, 00 }));
		System.out.println(sol.solution(new int[] { 3, 3, 34, 100000, 9, 303 }));
		System.out.println(sol.solution(new int[] { 1, 2, 3, 11, 12, 13, 111, 1212, 1313, 2 }));
		System.out.println(sol.solution(new int[] { 3230, 32 }));
		System.out.println(sol.solution(new int[] { 0, 0, 0, 0 }));
	}
}
