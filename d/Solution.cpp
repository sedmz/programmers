#include <vector>
#include <iostream>
using namespace std;

bool isSosu(int n) {
	if (n == 2)
		return true;

	for (int i = 2; i < n; i++) {
		if (n%i == 0)
			return false;
	}
	return true;
}

int solution(vector<int> nums) {
	int cnt = 0;
	for (int i = 0; i < nums.size() - 2; i++) {
		for (int j = i + 1; j < nums.size() - 1; j++) {
			for (int k = j + 1; k < nums.size(); k++) {
				if (isSosu(nums[i] + nums[j] + nums[k]))
					cnt++;
			}
		}

	}
	return cnt;
}
