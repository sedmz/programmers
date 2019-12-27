class Solution {
	public static String convert(int num) {
		String binaryString = Integer.toBinaryString(num);
		binaryString = binaryString.replace("1", "#");
		binaryString = binaryString.replace("0", " ");
		return binaryString;
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] result = new String[n];

		for (int i = 0; i < n; i++) {
			result[i] = convert(arr1[i] | arr2[i]);
			while (result[i].length() < n)
				result[i] = " " + result[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 5;
		int arr1[] = { 9, 20, 28, 18, 11 };
		int arr2[] = { 30, 1, 21, 17, 28 };
		String result[] = sol.solution(n, arr1, arr2);
		for (String str : result)
			System.out.println(str);
	}
}
