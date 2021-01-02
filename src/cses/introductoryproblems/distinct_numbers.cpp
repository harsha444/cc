#include<bits/stdc++.h>

using namespace std;

#define ll long long

int main() {
	ll n;
	cin >> n;
	set<int> s;
	for(ll i=0; i<n; i++) {
		ll input;
		cin >> input;
		s.insert(input);
	}
	cout << s.size();
	return 0;
}