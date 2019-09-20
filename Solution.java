import java.util.HashMap;

class Solution {
	public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<>();

		// participant ���ϱ�
		for (int i = 0; i < participant.length; i++) {
			if (map.containsKey(participant[i]))
				map.put(participant[i], (map.get(participant[i]) + 1));
			else
				map.put(participant[i], 1);
		}

		// completion ����
		for (int i = 0; i < completion.length; i++) {
			map.put(completion[i], map.get(completion[i]) - 1);
		}

		// 1�� ���� �� ã��
		for (String key : map.keySet()) {
			if (map.get(key) == 1)
				return key;
		}
		return "";
	}
}