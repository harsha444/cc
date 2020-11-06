#include <bits/stdc++.h>

using namespace std;

#define ll long long
#define max(x,y) (x>y)?x:y

int main() {
	ll n;
	cin >> n;
	for(int i=0; i<n; i++) {
		ll y, x;
		cin >> y >> x;
		ll max_value = max(y,x);
		ll addFirst = (max_value-1)*(max_value-1);
		ll response = 0;
		if(y==max_value) {
			if(y%2 == 0) {
				response = (y*y)-(x-1);
			} else {
				response = addFirst + x;
			}
		} else if (x==max_value) {
			if(x%2==0) {
				response = addFirst + y;
			} else {
				response = (x*x) - (y-1);
			}
		}
		cout << response << '\n';´
	}
	return 0;
}
