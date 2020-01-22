import java.util.ArrayList;

class Solution {
	public long solution(int n) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(0);
		arr.add(1);
		arr.add(2);

		for (int i = 3; i <= n; i++) {
			int value = arr.get(i - 1) + arr.get(i - 2);
			value = value < 1234567 ? value : value - 1234567;
			arr.add(value);
		}
		return arr.get(n);
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(4));
	}
}
