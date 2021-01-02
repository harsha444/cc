#include<bits/stdc++.h>

using namespace std;

int trap(vector<int>& height) {
	int n = height.size();
	vector<int> lMax(n);
	vector<int> rMax(n);
	int maxL = INT_MIN;
	int maxR = INT_MIN;
	for(int i=0, j=n-1; i<n && j>=0; i++,j--) {
		// Left array
		int currLmax = height[i];
		if(currLmax>maxL) {
			maxL = currLmax;
		}
		lMax[i] = maxL;
		// Right array
		int currRmax = height[j];
		if(currRmax>maxR) {
			maxR = currRmax;
		}
		rMax[j] = maxR;
	}
	int response = 0;
	for(int i=0; i<n; i++) {
		response += min(lMax[i], rMax[i])-height[i];
	}
	return response;
}

int trapWith2pointers(vector<int>& height) {
	int maxL = 0;
    int maxR = 0;
    int s = 0;
    int e = height.size()-1;
    int sum = 0;
    while(s<e) {
        maxL = max(maxL, height[s]);
        maxR = max(maxR, height[e]);
        if(maxL < maxR) {
            sum += (maxL - height[s]);
            s+=1;
        } else {
            sum += (maxR - height[e]);
            e-=1;
        }
    }
    return sum; 
}

int main() {
	int n;
	cin >> n;
	vector<int> a(n);
	for(int i=0; i<n; i++) {
		cin >> a[i];
	}
	cout << trap(a);
	return 0;
}