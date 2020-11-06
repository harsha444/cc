package cses.introductoryproblems;

import java.util.*;

public class NumberSpiral {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		for(int i=0; i<n; i++) {
			long y = sc.nextLong();
			long x = sc.nextLong();
			long max = Math.max(y,x);
			long addFirst = (max-1)*(max-1);
			long response = 0;
			if(y==max) {
				if(y%2 == 0) {
					response = (y*y)-(x-1);
				} else {
					response = addFirst + x;
				}
			} else if (x==max) {
				if(x%2==0) {
					response = addFirst + y;
				} else {
					response = (x*x) - (y-1);
				}
			}
			System.out.println(response);
		}
	}
}