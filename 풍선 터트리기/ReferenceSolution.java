import java.util.*;

class Solution {
	Set<Integer> set = new HashSet<>();
	
	public int solution(int[] a) {
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		
		for (int i = 0; i < a.length; i++) {
			min1 = Math.min(min1, a[i]);
			min2 = Math.min(min2, a[a.length - 1 - i]);
			set.add(min1);
			set.add(min2);
		}
		
		return set.size();
	}
}
