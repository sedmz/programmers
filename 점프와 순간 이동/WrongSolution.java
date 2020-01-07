import java.util.*;

public class Solution {
	public int[] battery = new int[100000001];

	public int solution(int n) {
		for (int i = 1; i <= n; i++) {
			int a = n, b = n;
			a = battery[i - 1] + 1;
			if (i % 2 == 0)
				b = battery[i / 2];
			battery[i] = Math.min(a, b);
		}
		return battery[n];
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(5000));
	}
}
