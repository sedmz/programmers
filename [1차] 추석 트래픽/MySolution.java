class Solution {
	int[] starts, ends;

	public int solution(String[] lines) {
		starts = new int[lines.length];
		ends = new int[lines.length];

		for (int i = 0; i < lines.length; i++) {
			String[] times = lines[i].split(" ")[1].split(":");
			int processTime = (int) (Double.parseDouble(lines[i].split(" ")[2].replace("s", "")) * 1000);
			int endTime = (int) (((Double.parseDouble(times[0]) * 60 + Double.parseDouble(times[1])) * 60
					+ Double.parseDouble(times[2])) * 1000);
			int startTime = (int) (endTime - processTime) + 1;

			starts[i] = startTime;
			ends[i] = endTime;
		}

		int max = 0;
		int[] count = new int[lines.length];
		for (int i = 0; i < starts.length; i++) {
			for (int j = i; j < starts.length; j++) {
				if (starts[j] < ends[i] + 1000) {
					count[i]++;
				}
			}
			max = Math.max(max, count[i]);
		}

		return max;
	}
}
