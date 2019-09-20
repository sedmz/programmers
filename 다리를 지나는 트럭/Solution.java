class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int sec = 0, nextIdx = 0, ingWeight = 0;
		int[] ingTruck = new int[truck_weights.length];
		for (int i = 0; i < ingTruck.length; i++)
			ingTruck[i] = 0;

		while (true) {
			sec++;
			for (int i = 0; i < ingTruck.length; i++) {
				if (ingTruck[i] > 0) {
					ingTruck[i]++;
					if (ingTruck[i] > bridge_length) {
						ingWeight -= truck_weights[i];
						ingTruck[i] = 0;
						if (i == ingTruck.length - 1)
							return sec;
					}
				}
			}
			if (nextIdx < truck_weights.length) {
				if (ingWeight + truck_weights[nextIdx] <= weight) {
					ingWeight += truck_weights[nextIdx];
					ingTruck[nextIdx]++;
					nextIdx++;
				}
			}
		}
	}
}
