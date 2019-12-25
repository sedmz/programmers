class Solution {
	public String[][] headNumTail;

	public void setHeadNumTail(String[] files) {
		headNumTail = new String[files.length][4];
		for (int i = 0; i < files.length; i++) {
			int start = 0, cnt = 0;
			boolean isStart = false;

			String file = files[i];
			for (int idx = 0; idx < file.length(); idx++) {
				if (Character.isDigit(file.charAt(idx))) {
					if (isStart == false) {
						isStart = true;
						start = idx;
					}
					cnt++;
				} else if (isStart == true)
					break;
			}

			headNumTail[i][0] = file.substring(0, start);
			headNumTail[i][1] = file.substring(start, start + cnt);
			headNumTail[i][2] = file.substring(start + cnt);
			headNumTail[i][3] = Integer.toString(i);
		}

	}

	public void swap(int i, int j) {
		String[] tmp = headNumTail[i];
		headNumTail[i] = headNumTail[j];
		headNumTail[j] = tmp;
	}

	public void sortHeadNumTail() {
		for (int i = 0; i < headNumTail.length - 1; i++) {
			for (int j = i + 1; j < headNumTail.length; j++) {
				String head1 = headNumTail[i][0].toLowerCase();
				String head2 = headNumTail[j][0].toLowerCase();
				if (head1.compareTo(head2) > 0) {
					swap(i, j);
				} else if (head1.compareTo(head2) == 0) {
					int number1 = Integer.parseInt(headNumTail[i][1]);
					int number2 = Integer.parseInt(headNumTail[j][1]);
					if (number1 > number2) {
						swap(i, j);
					} else if (number1 == number2) {
						int order1 = Integer.parseInt(headNumTail[i][3]);
						int order2 = Integer.parseInt(headNumTail[j][3]);
						if (order1 > order2)
							swap(i, j);
					}
				}
			}
		}
	}

	public String[] sortFiles(String[] files) {
		String[] answer = new String[headNumTail.length];

		for (int i = 0; i < answer.length; i++) {
			String head = headNumTail[i][0];
			String num = headNumTail[i][1];
			String tail = headNumTail[i][2];
			
			answer[i] = head + num + tail;
		}

		return answer;
	}

	public String[] solution(String[] files) {
		setHeadNumTail(files);
		sortHeadNumTail();
		return sortFiles(files);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		// String[] files = { "img12.png", "img10.png", "img02.png", "img1.png",
		// "IMG01.GIF", "img2.JPG" };
		// String[] files = { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10
		// Thunderbolt II", "F-14 Tomcat" };
		// String[] files = { "foo9.txt", "foo010bar020.zip", "F-15" };
		String[] files = { " 123", "a123" };
		sol.solution(files);
	}
}
