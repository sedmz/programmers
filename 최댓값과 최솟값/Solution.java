class Solution {
	public String solution(String s) {
		String[] number = s.split(" ");
		int min = Integer.parseInt(number[0]);
		int max = Integer.parseInt(number[0]);

		for (String val : number) {
			if (Integer.parseInt(val) < min)
				min = Integer.parseInt(val);
			else if (Integer.parseInt(val) > max)
				max = Integer.parseInt(val);
		}

		return new String(Integer.toString(min) + " " + Integer.toString(max));
	}
}
