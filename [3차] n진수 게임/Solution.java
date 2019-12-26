class Solution {
	public String totalNumber = "";

	public static int nToTen(int n, String num) {
		int result = 0, digit = 1, r;

		for (int i = num.length() - 1; i >= 0; i--) {
			String str = num.substring(i, i + 1);
			switch (str) {
			case "A":
				r = 10;
				break;
			case "B":
				r = 11;
				break;
			case "C":
				r = 12;
				break;
			case "D":
				r = 13;
				break;
			case "E":
				r = 14;
				break;
			case "F":
				r = 15;
				break;
			default:
				r = Integer.parseInt(str);
			}
			r *= digit;
			result += r;
			digit *= n;
		}
		return result;
	}

	public static String tenToN(int n, int num) {
		String result = "";
		while (num > 0) {
			int r = num % n;

			switch (r) {
			case 10:
				result = 'A' + result;
				break;
			case 11:
				result = 'B' + result;
				break;
			case 12:
				result = 'C' + result;
				break;
			case 13:
				result = 'D' + result;
				break;
			case 14:
				result = 'E' + result;
				break;
			case 15:
				result = 'F' + result;
				break;
			default:
				result = Integer.toString(r) + result;
			}
			num /= n;
		}
		return result;
	}

	public String nextNumber(int n, String number) {
		int ten = nToTen(n, number);
		return tenToN(n, ++ten);
	}

	public void setTotalNumber(int n, int t, int m, int p) {
		int totalNumberLength = m * (t - 1) + p;
		String number = Integer.toString(0);

		while (totalNumber.length() < totalNumberLength) {
			totalNumber += number;
			number = nextNumber(n, number);
		}
	}

	public String solution(int n, int t, int m, int p) {
		setTotalNumber(n, t, m, p);

		String result = "";
		for (int i = p - 1; result.length() < t; i = i + m)
			result += totalNumber.charAt(i);

		return result;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution(16, 1000, 100, 100).length();
	}
}
