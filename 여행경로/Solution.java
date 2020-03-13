import java.util.Arrays;
import java.util.Stack;

class Solution {
	static final int digit = 5;
	static final String none = "-----";
	String[] answer;

	public String[][] sort(String[][] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i][0].contentEquals(arr[j][0])) {
					if (arr[i][1].compareTo(arr[j][1]) < 0) {
						String tmp = arr[i][1];
						arr[i][1] = arr[j][1];
						arr[j][1] = tmp;
					}
				}
			}
		}
		return arr;
	}

	public String[] solution(String[][] tickets) {
		Stack<String> stack = new Stack<>();
		answer = new String[tickets.length + 1];
		tickets = sort(tickets);

		String s = "ICN ";
		for (int i = 0; i < tickets.length; i++)
			s += String.format("%05d", i);
		stack.add(s);

		while (!stack.isEmpty()) {
			s = stack.pop();
			String route = s.split(" ")[0];
			String start = route.substring(0, 3);
			String visitable = s.split(" ")[1];

			for (int i = 0; i < tickets.length; i++) {
				if (tickets[i][0].contentEquals(start)) {
					if (!visitable.substring(i * digit, i * digit + digit).equals(none)) {
						StringBuffer newVisitable = new StringBuffer(visitable);
						newVisitable.replace(i * digit, i * digit + digit, none);
						String newRoute = tickets[i][1] + route;
						stack.add(newRoute + " " + newVisitable);

						if (newRoute.length() / 3 == tickets.length + 1) {
							routeToArray(newRoute);
							return answer;
						}
					}
				}
			}
		}
		return null;
	}

	public void routeToArray(String route) {
		int n = answer.length - 1;
		for (int i = 0; i <= n; i++) {
			answer[n - i] = route.substring(i * 3, i * 3 + 3);
		}
	}
}
