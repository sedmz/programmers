import java.util.ArrayList;

class Solution {
	static ArrayList<String> list = new ArrayList<>();
	static ArrayList<Integer> num = new ArrayList<>();

	public int solution(String numbers) {
		// 모든 조합을 찾아내기
		for (int i = 0; i < numbers.length(); i++)
			DFS(i, numbers, "", "");

		// int형 변환
		for (int i = 0; i < list.size(); i++) {
			int n = Integer.parseInt(list.get(i));
			if (!num.contains(n))
				num.add(n);
		}

		// 소수 개수
		int cnt = 0;
		for (int i = 0; i < num.size(); i++)
			if (isSosu(num.get(i)))
				cnt++;

		return cnt;
	}

	public static void DFS(int idx, String numbers, String road, String s) {
		s += numbers.charAt(idx);
		list.add(s);
		road += idx;

		for (int i = 0; i < numbers.length(); i++)
			if (road.indexOf(Integer.toString(i)) == -1)
				DFS(i, numbers, road, s);
	}

	public static boolean isSosu(int n) {
		if (n < 2)
			return false;
		else if (n == 2)
			return true;

		for (int i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0)
				return false;
		return true;
	}
}
