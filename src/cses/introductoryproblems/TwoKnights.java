package cses.introductoryproblems;

import java.util.*;

public class TwoKnights {
	public static void printWays(long k) {
		long n = k*k;
		long nWays = n * (n-1)/2;
		if(k>2) {
			nWays -= 4*(k-1)*(k-2);
		}
		System.out.println(nWays);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			printWays(i);
		}
	}	
}