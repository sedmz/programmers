import java.util.Vector;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			Vector<Integer> v = new Vector<Integer>();
			for (int j = commands[i][0]; j <= commands[i][1]; j++) {
				if (j == commands[i][0])
					v.add(array[j - 1]);
				else if (array[j - 1] < v.get(0)) {
					v.add(0, array[j - 1]);
				} else {
					for (int k = v.size()-1; k >= 0; k--) {
						if (array[j - 1] >= v.get(k)) {
							v.add(k + 1, array[j - 1]);
							break;
						}
					}
				}
			}
			answer[i] = v.get(commands[i][2] - 1);
		}
		return answer;
	}
}
