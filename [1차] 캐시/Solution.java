import java.util.Vector;

class Solution {
	public int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0)
			return cities.length * 5;

		Vector<String> v = new Vector<>();
		for (int i = 0; i < cacheSize; i++)
			v.add("");

		int sec = 0;
		for (String city : cities) {
			city = city.toLowerCase();

			int idx = v.indexOf(city);
			if (idx > -1) {
				sec += 1;
				v.remove(idx);
				v.add(city);
			} else {
				sec += 5;
				v.remove(0);
				v.add(city);
			}
		}
		return sec;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		// int cacheSize = 3;
		// String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju",
		// "Pangyo", "Seoul", "NewYor", "LA" };
		// int cacheSize = 3;
		// String[] cities = { "Jeju", "Pangyo", "Seoul", "Jeju","Pangyo", "Seoul",
		// "Jeju", "Pangyo", "Seoul" };
		// int cacheSize = 2;
		// String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork","LA",
		// "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" };
		int cacheSize = 0;
		String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
		sol.solution(cacheSize, cities);
	}
}
