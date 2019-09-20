import java.util.Vector;

class Solution {
	public int[] solution(int n, int m) {
		int[] answer = new int[2];

		// 약수
		Vector<Integer> v = new Vector<>();
		v.add(n);
		for (int i = n / 2; i > 0; i--) {
			if (n % i == 0)
				v.add(i);
		}

		for (int num : v) {
			if (m % num == 0) {
				answer[0] = num;
				break;
			}
		}

		// 배수
		int max = n > m ? n : m;
		for (int i = max; i <= m * n; i++) {
			if (i % n == 0 && i % m == 0) {
				answer[1] = i;
				break;
			}
		}
		return answer;
	}
}
