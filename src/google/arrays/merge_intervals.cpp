#include<bits/stdc++.h>

using namespace std;

bool sortByStart(vector<int> a, vector<int> b) {
	return a[0]<b[0];
}

void print(vector<vector<int>> r) {
	for(auto i: r) {
		cout << i[0] << " " << i[1] << "\n";
	}
}

vector<vector<int>> merge(vector<vector<int>>& intervals) {
	vector<vector<int>> resp;
	sort(intervals.begin(), intervals.end(), sortByStart);
	stack<vector<int>> s;
	s.push(intervals[0]);
	for(int i=1; i<intervals.size(); i++) {
		vector<int> top = s.top();
		if(intervals[i][0] > top[1]) {
			s.push(intervals[i]);
		} else if(top[1] < intervals[i][1]) {
			s.pop();
			s.push({top[0], intervals[i][1]});
		}
	}
	while(!s.empty()) {
		resp.push_back(s.top());
		s.pop();
	}
	reverse(resp.begin(), resp.end());
	return resp;
}

int main() {
	vector<vector<int>> r = {{15,18},{1,3},{2,6},{8,10}};
	print(merge(r));
	return 0;
}