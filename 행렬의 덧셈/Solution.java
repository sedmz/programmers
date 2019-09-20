class Solution {
	public String solution(String phone_number) {
		StringBuilder str = new StringBuilder(phone_number);
		for (int i = str.length() - 5; i >= 0; i--)
			str.setCharAt(i, '*');

		return str.toString();
	}
}
