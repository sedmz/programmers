class Solution {
	class Time {
		int hour, minute, crew = 0, start = -1, end = -1;

		public Time() {

		}

		public Time(int hour, int minute) {
			this.hour = hour;
			this.minute = minute;
		}

		public Time(String time) {
			hour = Integer.parseInt(time.split(":")[0]);
			minute = Integer.parseInt(time.split(":")[1]);
		}

		public Time oneMinuteBefore() {
			minute -= 1;
			if (minute < 0) {
				minute += 60;
				hour -= 1;
			}
			return this;
		}

		public int compare(Time time) {
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
		// 정렬

		int hour = 9, minute = 0;
		for (int i = 0; i < n; i++) {
			shuttle[i] = new Time(hour, minute);
			minute += t;
			if (minute >= 60) {
				hour += 1;
				minute -= 60;
			}
		}

		for (int j = 0; j < timetable.length; j++) {
			String time = timetable[j];
			hour = Integer.parseInt(time.split(":")[0]);
			minute = Integer.parseInt(time.split(":")[1]);
			for (int i = 0; i < n; i++) {
				if (shuttle[i].compare(new Time(hour, minute)) >= 0) {
					if (shuttle[i].crew < m) {
						shuttle[i].crew++;
						if (shuttle[i].crew == 1)
							shuttle[i].start = j;
						shuttle[i].end = j;
						break;
					}
				}
			}
		}

		Time answer = new Time();
		for (int i = n - 1; i >= 0; i--) {
			if (shuttle[i].crew < m) {
				answer = shuttle[i];
				break;
			} else {
				answer = new Time(timetable[shuttle[i].start]).oneMinuteBefore();
				break;
			}
		}

		return answer.toString();
	}
}
