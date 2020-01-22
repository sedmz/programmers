import java.util.Vector;

class Solution {
	public int solution(int n) {
		int answer = 0;

		Vector<Integer> v = new Vector<>();
		v.add(-1);
		v.add(-1);
		for (int i = 2; i <= n; i++)
			v.add(i);

		for (int i = 0; i < v.size(); i++) {
			int num = v.get(i);
			if (num == -1)
				continue;
			answer++;
			int tmp = 1;
			while (true) {
				if (i * ++tmp >= v.size())
					break;
				v.set(i * tmp, -1);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(10);
	}
}
