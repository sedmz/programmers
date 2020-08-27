import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
	public String[] operations = { "+-*", "+*-", "-+*", "-*+", "*+-", "*-+" };
	public Queue<String> queue;
	public String[] symbols;

	public long solution(String expression) {
		split(expression);

		long max = -1;
		for (String operation : operations) {
			queue = new LinkedList<>();
			for (String symbol : symbols)
				queue.add(symbol);

			for (char op : operation.toCharArray()) {
				calculate(op);
			}

			max = Math.max(max, Math.abs(Long.parseLong(queue.poll())));
		}
		return max;
	}

	public void calculate(char op) {
		Stack<String> stack = new Stack<>();
		while (!queue.isEmpty()) {
			String str = queue.poll();

			if (str.equals(op + "")) {
				long a = Long.parseLong(stack.pop());
				long b = Long.parseLong(queue.poll());

				switch (op) {
				case '+':
					stack.add(Long.toString(a + b));
					break;
				case '-':
					stack.add(Long.toString(a - b));
					break;
				case '*':
					stack.add(Long.toString(a * b));
					break;
				default:
					System.out.println("ERROR");
				}
			} else {
				stack.add(str);
			}
		}
		queue.addAll(stack);
	}

	public void split(String expression) {
		expression = expression.replace("+", " + ");
		expression = expression.replace("-", " - ");
		expression = expression.replace("*", " * ");
		symbols = expression.split(" ");
	}
}
