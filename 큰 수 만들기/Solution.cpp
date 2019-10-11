#include <string>
#include <vector>
#include <iostream>

using namespace std;

int getMaxIndex(string number) {
	int maxIndex = 0;
	for (int i = 0; i < number.length(); i++) {
		if ((int)(number.at(i)) > (int)number.at(maxIndex))
			maxIndex = i;
	}
	return maxIndex;
}
string solution(string number, int k) {
	string answer = "";
	int startIndex = 0;
	bool isLast = false;

	while (k > 0) {
		cout << 1 << endl;
		int maxIndex = getMaxIndex(number.substr(startIndex, k + 1)) + startIndex;
		answer += number.substr(maxIndex, 1);
		k -= (maxIndex - startIndex);
		startIndex = maxIndex + 1;

		if (k == number.substr(startIndex).length()) {
			isLast = true;
			break;
		}
	}
	if (isLast == false)
		answer += number.substr(startIndex);
	return answer;
}
