#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n, vector<string> words) {
	vector<int> answer;

	vector<string>::iterator it;
	string beforeWord = words.at(0).substr(0,1);
	bool isError = false;
	int index = 0;

	for (it = words.begin(); it != words.end(); it++) {
		vector<string>::iterator itForCompare;
		for (itForCompare = words.begin(); itForCompare != it; itForCompare++) {
			if (*itForCompare == *it) {
				isError = true;
				break;
			}
		}

		if (beforeWord.substr(beforeWord.size() - 1, 1) != (*it).substr(0, 1))
			isError = true;

		if (isError == true) {
			answer.push_back(index%n + 1);
			answer.push_back(index / n + 1);
			return answer;
		}
		index++;
		beforeWord = *it;
	}

	answer.push_back(0);
	answer.push_back(0);
	return answer;
}
