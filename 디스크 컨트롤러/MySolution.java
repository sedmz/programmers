import java.util.*;

class Solution {
	PriorityQueue<int[]> remainJobs = new PriorityQueue<>(newComparator(1));

	public Comparator<int[]> newComparator(int i) {
		Comparator<int[]> comparator = new Comparator<>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[i], o2[i]);
			}
		};
		return comparator;
	}

	public int solution(int[][] jobs) {
		Arrays.sort(jobs, newComparator(0));

		int i = 0, sec = 0, answer = 0;
		while (i < jobs.length || !remainJobs.isEmpty()) {
			while (i < jobs.length && jobs[i][0] <= sec) {
				remainJobs.add(jobs[i++]);
			}

			if (remainJobs.isEmpty()) {
				sec = jobs[i][0];
			} else {
				int[] job = remainJobs.poll();
				answer += job[1] + sec - job[0];
				sec += job[1];
			}
		}
		return answer / jobs.length;
	}
}
