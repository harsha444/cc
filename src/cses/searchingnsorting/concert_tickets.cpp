#include<bits/stdc++.h>
#define ld long double
#define ll long long
#define ar array

using namespace std;

const ll mod = 1e9 + 7;

int main() {
	ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    ll n, m, curr, ticket;
	cin >> n >> m;
	set<ar<int, 2>> s;
	for(int i=0; i<n; i++) {
		int a;
		cin >> a;
		s.insert({a, i});
	}
	for(array<int, 2> x: s) {
		cout << x[0] << x[1];
	}
	for(int i=0; i<m; i++) {
		int t;
		cin >> t;
		auto it = s.lower_bound({t+1, 0});
	}
	return 0;
}