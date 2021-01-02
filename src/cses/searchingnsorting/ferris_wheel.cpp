#include<bits/stdc++.h>

using namespace std;

#define ll long long

const int mxN=2e5;
int n, x, a[mxN];
// This is an interesting question. Watch the video if you don't understand in future.
// Basically we are trying to find the possible ways where 2 children can fit in a gandola and subtract it from total children
int main() {
	cin >> n >> x;
	for(int i=0; i<n; i++) {
		cin >> a[i];
	}
	sort(a, a+n);
	int ans = 0;
	for(int i=0, j=n-1; i<j; ){
		while(i<j && a[i]+a[j]>x) {
			--j;
		}
		if(i>=j) {
			break;
		}
		++ans;
		++i, --j;
	}
	cout << n-ans;
	return 0;
}