package cses.introductoryproblems;

import java.util.*;

public class BitStrings {
	public static void main(String[] args) {
		long MOD=(long)1e9+7;
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long response = 1;
		for(long i=0; i<n; i++) {
			response = (2*response)%MOD;
		}
		System.out.println(response);
	}
}