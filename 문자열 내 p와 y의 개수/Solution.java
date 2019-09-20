class Solution {
	boolean solution(String s) {
		s = s.toLowerCase();

		int pNum = 0, yNum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'p')
				pNum++;
			if (s.charAt(i) == 'y')
				yNum++;
		}

		if (pNum == yNum)
			return true;
		else
			return false;
	}
}
