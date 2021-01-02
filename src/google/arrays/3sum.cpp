#include<bits/stdc++.h>

using namespace std;

void twoSum(vector<int>& nums, int i, vector<vector<int>>& resp) {
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

vector<vector<int>> threeSum(vector<int>& nums) {
	int n = nums.size();

	set<vector<int>> resp;
	unordered_set<vector<int>> dups;
	unordered_map<int, int> m;

	for(int i=0; i<n; i++) {
		if(dups.insert(nums[i])) {
			
		}
	}
	return resp;
}

int main() {
	int n;
	cin >> n;
	vector<int> a(n);
	for(int i=0; i<n; i++) {
		cin >> a[i];
	}
	cout << threeSum(a);
	return 0;
}