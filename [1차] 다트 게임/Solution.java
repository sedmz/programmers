class Solution {
	public int solution(String dartResult) {
		dartResult = dartResult + " ";
		int score[] = new int[3];

		int idx = 0;
		for (int i = 0; i < score.length; i++) {
			while (Character.isDigit(dartResult.charAt(idx))) {
				score[i] *= 10;
				score[i] += dartResult.charAt(idx++) - '0';
			}
			switch (dartResult.charAt(idx++)) {
			case 'S':
				score[i] = score[i];
				break;
			case 'D':
				score[i] = score[i] * score[i];
				break;
			case 'T':
				score[i] = score[i] * score[i] * score[i];
				break;
			}
			if (!Character.isDigit(dartResult.charAt(idx))) {
				switch (dartResult.charAt(idx++)) {
				case '*':
					if (i != 0)
						score[i - 1] *= 2;
					score[i] *= 2;
					break;
				case '#':
					score[i] *= -1;
					break;
				}
			}
		}
		int sum = 0;
		for (int s : score) {
			sum += s;
		}
		return sum;
	}
}
