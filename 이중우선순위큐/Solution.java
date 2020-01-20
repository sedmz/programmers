import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public int[] solution(String[] operations) {
		List<Integer> list = new ArrayList<>();

		for (String operation : operations) {
			switch (operation.charAt(0)) {
			case 'I':
				list.add(Integer.parseInt(operation.substring(2)));
				Collections.sort(list);
				break;
			case 'D':
				if (list.size() > 0)
					switch (operation.substring(2)) {
					case "1":
						list.remove(list.size() - 1);
						break;
					case "-1":
						list.remove(0);
						break;
					}
				break;
			}
		}
		if (list.size() == 0)
			return new int[] { 0, 0 };
		return new int[] { list.get(list.size() - 1), list.get(0) };
	}
}
