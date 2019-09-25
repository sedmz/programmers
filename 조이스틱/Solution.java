// char형 배열 -> string : String.copyValueOf(arr)

class Solution {
	public int solution(String name) {
		char[] alpha = new char[name.length()];
		for (int i = 0; i < alpha.length; i++)
			alpha[i] = 'A';

		int i = 0, sum = 0;
		while (true) {
			char ch = name.charAt(i);
			int n = ch - 'A';
			if (n > 13)
				n = 26 - n;
			sum += n;
			
			alpha[i] = ch;
			if (String.copyValueOf(alpha).equals(name))
				break;

			int left = (i - 1 + name.length()) % name.length();
			int right = (i + 1) % name.length();

			// 다음 방향 잡기
			if (alpha[left] == name.charAt(left) && alpha[right] == name.charAt(right)) {
				int l = i, r = i;
				while (true) {
					l = (--l + name.length()) % name.length();
					r = ++r % name.length();

					if (l == r) {
						i = left;
						break;
					} else if (alpha[l] == name.charAt(l) && alpha[r] != name.charAt(r)) {
						i = right;
						break;
					} else if (alpha[r] == name.charAt(r) && alpha[l] != name.charAt(l)) {
						i = left;
						break;
					}
				}
			} else if (alpha[right] == name.charAt(right))
				i = left;
			else if (alpha[left] == name.charAt(left))
				i = right;
			else
				i = right;
			sum++;
		}
		return sum;
	}
}
