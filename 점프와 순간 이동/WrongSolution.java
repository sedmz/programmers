import java.util.*;

public class Solution {
	ArrayList<Integer> battery = new ArrayList<>();
	
	public int solution(int n) {
		battery.add(0);
		for (int i = 1; i <= n; i++) {
			int a = n, b = n;
			a = battery.get(i - 1) + 1;
			if (i % 2 == 0)
				b = battery.get(i / 2);
			battery.add(a > b ? b : a);
		}
		return battery.get(n);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(5000));
	}
}
