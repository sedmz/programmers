import java.util.ArrayList;
import java.util.Stack;

class Solution {
	Stack<String> stack = new Stack<>();
	ArrayList<String> list = new ArrayList<>();
	ArrayList<String> temp = new ArrayList<>();

	public void setStrings() {
		stack.add(" ACFJMNRT");

		while (!stack.isEmpty()) {
			String[] s = stack.pop().split(" ");

			if (s.length > 1)
				for (char ch : s[1].toCharArray()) {
					String s0 = s[0] + ch;
					String s1 = s[1].replace(ch + "", "");
					stack.add(s0 + " " + s1);
				}
			else
				list.add(s[0]);
		}
	}

	public void checkCondition(String[] data) {
		for (String d : data) {
			char X = d.charAt(0), Y = d.charAt(2);
			char op = d.charAt(3);
			int N = d.charAt(4) - '0';

			for (String str : list) {
				int diff = Math.abs(str.indexOf(X) - str.indexOf(Y)) - 1;
				
				switch (op) {
				case '=':
					if (diff == N)
						temp.add(str);
					break;
				case '>':
					if (diff > N)
						temp.add(str);
					break;
				case '<':
					if (diff < N)
						temp.add(str);
					break;
				}
			}
			list.clear();
			list.addAll(temp);
			temp.clear();
		}
	}

	public int solution(int n, String[] data) {
		setStrings();
		checkCondition(data);
		return list.size();
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(2, new String[] { "N~F=0", "R~T>2" }));
	}
}
