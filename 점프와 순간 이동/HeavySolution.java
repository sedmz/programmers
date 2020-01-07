import java.util.*;

public class Solution {
	public int min;

	public void dfs(int val, int cnt, int n) {
		if (val == n) {
			if (cnt < min)
				min = cnt;
			return;
		} else if (cnt > min)
			return;
		else if (val > n)
			return;

		dfs(val * 2, cnt, n);
		dfs(val + 1, cnt + 1, n);
	}

	public int solution(int n) {
		min = n;
		dfs(2,1, n);
		return min;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(5));
	}
}
