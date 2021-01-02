package cses.introductoryproblems;

import java.util.*;

public class DistinctNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		Set<Long> set = new HashSet<>();
		for(long i=0; i<n; i++) {
			long input = sc.nextLong();
			set.add(input);
		}
		System.out.println(set.size());
	}
}