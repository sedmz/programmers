#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle) {
	int i, j;
	for (i = 0; i < triangle.size(); i++) {
		if (i == 0)
			continue;

		for (j = 0; j < triangle[i].size(); j++) {
			int max;
			if (j == 0) {
				max = triangle[i - 1][j];
			}
			else if (j == triangle[i].size() - 1) {
				max = triangle[i - 1][j - 1];
			}
			else {
				int left = triangle[i - 1][j - 1];
				int right = triangle[i - 1][j];
				max = left > right ? left : right;
			}
			triangle[i][j] += max;
		}

	}

	i--;
	int max = -1;
	for (int j = 0; j < triangle[i].size(); j++) {
		if (triangle[i][j] > max)
			max = triangle[i][j];
	}
	return max;
}
