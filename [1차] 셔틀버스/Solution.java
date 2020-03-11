import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
	class Time implements Comparable<Time> {
		int hour, minute;

		public Time(Time time) {
			this.hour = time.hour;
			this.minute = time.minute;
		}

		public Time(String time) {
			hour = Integer.parseInt(time.split(":")[0]);
			minute = Integer.parseInt(time.split(":")[1]);
		}

		@Override
		public int compareTo(Time time) {
			if (this.hour < time.hour)
				return -1;
			else if (this.hour > time.hour)
				return 1;
			else {
				if (this.minute < time.minute)
					return -1;
				else if (this.minute > time.minute)
					return 1;
				else
					return 0;
			}
		}

		public Time calculate(int t) {
			Time time = new Time(this);
			time.minute += t;
			if (time.minute < 0) {
				time.minute += 60;
				time.hour--;
			}
			if (time.minute >= 60) {
				time.minute -= 60;
				time.hour++;
			}
			return time;
		}

		public String toString() {
			String str = "";
			if (hour < 10)
				str += "0";
			str += hour + ":";
			if (minute < 10)
				str += "0";
			str += minute;
			return str;
		}
	}

	public String solution(int n, int t, int m, String[] timetable) {
		Time[] shuttle = new Time[n];

		shuttle[0] = new Time("09:00");
		for (int i = 1; i < n; i++)
			shuttle[i] = shuttle[i - 1].calculate(t);

		PriorityQueue<Time> queue = new PriorityQueue<>();
		for (String time : timetable)
			queue.add(new Time(time));

		ArrayList<Time>[] list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();

			while (list[i].size() < m && !queue.isEmpty()) {
				if (queue.peek().compareTo(shuttle[i]) > 0)
					break;
				list[i].add(queue.poll());
			}
		}

		if (list[n - 1].size() == m)
			return list[n - 1].get(m - 1).calculate(-1).toString();
		return shuttle[n - 1].toString();
	}
}
