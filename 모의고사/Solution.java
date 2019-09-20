class Solution {
	public int[] solution(int[] answers) {
		int[] s1 = { 1, 2, 3, 4, 5 };
		int[] s2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] s3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int[] cnt = { 0, 0, 0 };

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == s1[i % s1.length])
				cnt[0]++;
			if (answers[i] == s2[i % s2.length])
				cnt[1]++;
			if (answers[i] == s3[i % s3.length])
				cnt[2]++;
		}

		int max = -1, num = 0;
		for (int n : cnt) {
			if (max < n) {
				max = n;
				num = 1;
			} else if (max == n)
				num++;
		}

		int[] answer = new int[num];
		for (int i = 0, idx = -1; i < cnt.length; i++) {
			if (cnt[i] == max)
				answer[++idx] = i + 1;
		}

		return answer;
	}
}
