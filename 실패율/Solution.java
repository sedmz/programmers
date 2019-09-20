class Solution {
	public int[] solution(int N, int[] stages) {
		double[] ratio = new double[N];

		int players = stages.length;
		int failure = 0;

		for (int stage = 1; stage <= N; stage++) {
			players -= failure;
			failure = 0;

			for (int i = 0; i < stages.length; i++) {
				if (stages[i] == stage)
					failure++;
			}
if (players != 0)
				ratio[stage - 1] = (double) failure / players;
			else
				ratio[stage - 1] = 0;
		}

		int[] answer = new int[N];
		for (int i = 0; i < ratio.length; i++) {
			double max = -1;
			int maxIdx = -1;
			for (int j = 0; j < ratio.length; j++) {
				if (max < ratio[j]) {
					max = ratio[j];
					maxIdx = j;
				}
			}
			answer[i] = maxIdx+1;
			ratio[maxIdx] = -1;
		}
		
		return answer;
	}
}
