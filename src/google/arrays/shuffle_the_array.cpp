#include<bits/stdc++.h>

using namespace std;

vector<int> shuffle(vector<int>& nums, int n) {
	vector<int> response(nums.size());
	int f = 0;
	int s = n;
	for(int i=0; i<nums.size(); i+=2) {
		response[i] = nums[f];
		response[i+1] = nums[s];
		f+=1;
		s+=1;
	}
	return response;
}

int main() {
	int sz;
	cin >> sz;
	vector<int> a(sz);
	for(int i=0; i<sz; i++) {
		cin >> a[i];
	}
	int n;
	cin >> n;
	vector<int> response = shuffle(a, n);
	for(auto i: response) {
		cout << i << " ";
	}
	return 0;
}