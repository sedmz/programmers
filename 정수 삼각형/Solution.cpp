#include <string>
#include <vector>
#include <iostream>

using namespace std;

int getMax(int left, int right) {
	if (left > right)
		return left;
	return right;
}

int getMax(vector<vector<int>> triangle, int i, int j) {
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
		max = getMax(left, right);
	}
	return max;
}

int getMax(vector<vector<int>> triangle) {
	int max = -1;
	int lastLine = triangle.size() - 1;
	for (int j = 0; j < triangle[lastLine].size(); j++) {
		if (triangle[lastLine][j] > max)
			max = triangle[lastLine][j];
	}
	return max;
}

int solution(vector<vector<int>> triangle) {
	for (int i = 1; i < triangle.size(); i++) {
		for (int j = 0; j < triangle[i].size(); j++) {
			int max = getMax(triangle, i, j);
			triangle[i][j] += max;
		}
	}

	return getMax(triangle);
}
