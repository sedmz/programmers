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

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(new String[] { "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s" });
//		sol.solution(new String[] { "2016-09-15 23:59:59.999 0.001s" });
//		sol.solution(new String[] { "2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s" });
//		sol.solution(new String[] { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
//				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
//				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
//				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" });
}}
