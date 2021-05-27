import java.util.Arrays;

class Solution {
	public long[] solution(long[] numbers) {
		return Arrays.stream(numbers).map(x -> calculate(x)).toArray();
	}
	
	public long calculate(long number) {
		StringBuffer binary = new StringBuffer("0" + Long.toBinaryString(number));
		
		for (int i = binary.length() - 1; i >= 0; i--) {
			if (binary.charAt(i) == '0') {
				if (i + 1 < binary.length()) {
					return Long.parseLong(binary.replace(i, i + 2, "10").toString(), 2);
				} else {
					return Long.parseLong(binary.replace(i, i + 1, "1").toString(), 2);
				}
			}
		}
		return Long.parseLong(binary.toString(), 2);
	}
}
