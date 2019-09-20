class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int[] student = new int[n];

		for (int i = 0; i < student.length; i++)
			student[i] = 0;

		for (int i : reserve)
			++student[i - 1];

		for (int i : lost)
			--student[i - 1];

		// 하나만 나눠줄 수 있는 경우
		for (int i = 0; i < student.length; i++) {
			int cnt = 0;
			int lr = 0;
			if (student[i] == 1) {
				if (i > 0)
					if (student[i - 1] == -1) {
						cnt++;
						lr = -1;
					}

				if (i < student.length - 1)
					if (student[i + 1] == -1) {
						cnt++;
						lr = 1;
					}

				if (cnt == 1) {
					if (lr == -1) {
						--student[i];
						++student[i - 1];
					} else if (lr == 1) {
						--student[i];
						++student[i + 1];
					}
				}
			}
		}
		
		// 하나만 나눠줄 수 있는 경우
		for (int i = 0; i < student.length; i++) {
			int cnt = 0;
			int lr = 0;
			if (student[i] == 1) {
				if (i > 0)
					if (student[i - 1] == -1) {
						cnt++;
						lr = -1;
					}

				if (i < student.length - 1)
					if (student[i + 1] == -1) {
						cnt++;
						lr = 1;
					}

				if (cnt == 1) {
					if (lr == -1) {
						--student[i];
						++student[i - 1];
					} else if (lr == 1) {
						--student[i];
						++student[i + 1];
					}
				}
			}
		}
		
		// 두개 나눠줘야 하는 경우
		for (int i = 0; i < student.length; i++) {
			if (student[i] == 1) {
				if (i > 0)
					if (student[i - 1] == -1) {
						student[i] = 0;
						student[i - 1] = 0;
					}

			}
			if (student[i] == 1) {
				if (i < student.length - 1)
					if (student[i + 1] == -1) {
						student[i] = 0;
						student[i + 1] = 0;
					}
			}
		}

		int cnt = 0;
		for (int i : student) {
			if (i >= 0)
				cnt++;
		}
		return cnt;
	}
}
