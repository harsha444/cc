package cses.introductoryproblems;

import java.util.*;

public class MissingNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long arrSum = 0;
		for(int i=0; i<n-1; i++) {
			arrSum += sc.nextLong();
		}
		long nSum = (n*(n+1))/2;
		System.out.println(nSum-arrSum);
	}
}
