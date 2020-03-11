import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
	static final int MIN_PER_HOUR = 60;
	static final int FIRST_BUS = 9;

	int[] bus;
	PriorityQueue<Integer> crew;
	ArrayList<Integer>[] ride;

	public void initBus(int n, int t) {
		bus = new int[n];
		bus[0] = FIRST_BUS * MIN_PER_HOUR;
		for (int i = 1; i < n; i++)
			bus[i] = bus[i - 1] + t;
	}

	public void initCrew(String[] timetable) {
		crew = new PriorityQueue<>();
		for (String time : timetable) {
			int hour = Integer.parseInt(time.split(":")[0]);
			int minute = Integer.parseInt(time.split(":")[1]);
			crew.add(hour * MIN_PER_HOUR + minute);
		}
	}

	public void rideBus(int n, int m) {
		ride = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			ride[i] = new ArrayList<>();
			while (ride[i].size() < m && !crew.isEmpty()) {
				if (crew.peek() > bus[i])
					break;
				ride[i].add(crew.poll());
			}
		}
	}

	public int getLastTime(int n, int m) {
		if (ride[n - 1].size() == m)
			return ride[n - 1].get(m - 1) - 1;
		return bus[n - 1];
	}

	public String timeToString(int n) {
		int hour = n / MIN_PER_HOUR;
		int minute = n % MIN_PER_HOUR;
		return String.format("%02d:%02d", hour, minute);
	}

	public String solution(int n, int t, int m, String[] timetable) {
		initBus(n, t);
		initCrew(timetable);
		rideBus(n, m);

		int answer = getLastTime(n, m);
		return timeToString(answer);
	}
}
