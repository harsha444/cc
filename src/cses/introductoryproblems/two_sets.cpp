#include <bits/stdc++.h>

using namespace std;

#define ll long long
#define vi vector<int>
#define vll vector<long long>

int printSets(ll n) {
	vll fList, sList;
	if(n<=2) {
		cout << "NO";
		return 0;
	}
	if(n>3 && n%4!=0 && (n-3)%4!=0) {
		cout << "NO";
		return 0;
	}

	if(n%4==0) {	
		for(ll i=1; i<n; i+=4) {
			fList.push_back(i);
			if(i+1 < n && i+2 < n && i+3<=n){
				sList.push_back(i+1);
				sList.push_back(i+2);
				fList.push_back(i+3);
			}
		}
	} else {
		fList.push_back(1L);
		fList.push_back(2L);
		sList.push_back(3L);
		for(ll i=4; i<n; i+=4) {
			sList.push_back(i);
			if(i+1 < n && i+2 < n && i+3<=n){
				fList.push_back(i+1);
				fList.push_back(i+2);
				sList.push_back(i+3);
			}
		}
	}
	cout << "YES" << '\n';
	cout << fList.size() << '\n';
	for(ll val: fList) {
		cout << val << " ";
	}
	cout << '\n';
	cout << sList.size() << '\n';
	for(ll val: sList) {
		cout << val << " ";
	}
}

int main() {
	ll n;
	cin >> n;
	printSets(n);
	return 0;
}