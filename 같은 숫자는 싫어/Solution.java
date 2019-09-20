import java.util.*;

public class Solution {
	public int[] solution(int[] arr) {
		Vector<Integer> v = new Vector<Integer>();

		int before = -1;
		for (int value : arr) {
			if (before != value) {
				v.add(value);
				before = value;
			}
		}

		int[] answer = new int[v.size()];
		for (int i = 0; i<v.size(); i++)
			answer[i] = v.get(i);
			
		return answer;
	}
}
