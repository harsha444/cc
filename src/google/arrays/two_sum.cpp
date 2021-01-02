#include <bits/stdc++.h>

using namespace std;

// https://leetcode.com/problems/two-sum/

bool sortBySecond(pair<int, int> a, pair<int, int> b) {
	return a.second < b.second;
}

vector<int> twoSum(vector<int> nums, int target) {
	int endIndex = nums.size() - 1;
	int startIndex = 0;
	vector<pair<int, int>> indexMap;
	for(int i=0; i<nums.size(); i++) {
		indexMap.push_back({nums[i], i});
	}
	vector<int> response;
	while(startIndex < endIndex) {
		if(indexMap[startIndex].first + indexMap[endIndex].first == target) {
			response.push_back(indexMap[startIndex].second);
			response.push_back(indexMap[endIndex].second);
			return response;
		} else if (indexMap[startIndex].first + indexMap[endIndex].first < target) {
			startIndex += 1;
		} else {
			endIndex -= 1;
		}
	}
	return response;
}

vector<int> twoSumWithHashMap(vector<int>& nums, int target) {
	vector<int> response;
	unordered_map<int, int> m;
	for(int i=0; i<nums.size(); i++) {
		int diff = target - nums[i];
		if(m.count(diff)) {
			response.push_back(m[diff]);
			response.push_back(i);
			return response;
		}
		m[nums[i]] = i;
	}
	return response;
}

int main() {
	int n;
	cin >> n;
	vector<int> a(n);
	for(int i=0; i<n; i++) {
		cin >> a[i];
	}
	int target;
	cin >> target;
	vector<int> resp = twoSumWithHashMap(a, target);
	cout << resp[0] << "---" << resp[1];
	return 0;
}