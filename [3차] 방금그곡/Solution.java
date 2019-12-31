class Solution {

	public String convert(String string) {
		string = string.replace("C#", "1");
		string = string.replace("D#", "2");
		string = string.replace("F#", "3");
		string = string.replace("G#", "4");
		string = string.replace("A#", "5");
		return string;
	}

	public int calculatePlayTime(String musicinfo) {
		String[] start = musicinfo.split(",")[0].split(":");
		String[] end = musicinfo.split(",")[1].split(":");

		int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
		int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
		return endTime - startTime;
	}

	public String solution(String m, String[] musicinfos) {
		String maxTitle = "(None)";
		int maxPlayTime = -1;

		for (String musicinfo : musicinfos) {
			String title = musicinfo.split(",")[2];
			String scale = musicinfo.split(",")[3];

			int playTime = calculatePlayTime(musicinfo);
			scale = convert(scale);
			m = convert(m);

			while (scale.length() < playTime)
				scale += scale;
			scale = scale.substring(0, playTime);

			if (scale.indexOf(m) != -1) {
				if (maxPlayTime < playTime) {
					maxPlayTime = playTime;
					maxTitle = title;
				}
			}
		}
		return maxTitle;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();

		/*
		 * String t = sol.solution("ABCDEFG", new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" });
		 */
		/*
		 * String t = sol.solution("CC#BCC#BCC#BCC#B", new String[] {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B" });
		 */

		String t = sol.solution("ABC", new String[] { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" });
	}
}
