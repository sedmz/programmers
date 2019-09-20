import java.util.HashMap;

class Solution {
	public String[] solution(String[] record) {
		HashMap<String, String> map = new HashMap<String, String>();
		String[][] arr = new String[record.length][3];

		int size = 0;
		for (int i = 0; i < record.length; i++) {
			arr[i] = record[i].split(" ");

			if (arr[i][0].equals("Enter") || arr[i][0].equals("Change"))
				map.put(arr[i][1], arr[i][2]);
			if (arr[i][0].equals("Enter") || arr[i][0].equals("Leave"))
				size++;
		}

		int idx = -1;
		String[] answer = new String[size];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0].equals("Enter"))
				answer[++idx] = map.get(arr[i][1]) + "님이 들어왔습니다.";
			else if (arr[i][0].equals("Leave"))
				answer[++idx] = map.get(arr[i][1]) + "님이 나갔습니다.";
		}
		return answer;
	}
}
