package cses.introductoryproblems;

import java.util.*;

/*
1,2,3,4
{1,2 + 3}
1,2,3,4,5,6,7
{1,2,3} 4(5,6)7, 8,(9,10),11
{1,(2,3),4}
{1,2,3,4},{5,6,7,8},..
*/

public class TwoSets {
	public static void printSets(long n) {
		ArrayList<Long> fList = new ArrayList<>();
		ArrayList<Long> sList = new ArrayList<>();
		if(n<=2) {
			System.out.println("NO");
			return;
		}
		if(n>3 && n%4!=0 && (n-3)%4!=0) {
			System.out.println("NO");
			return;
		}

		if(n%4==0) {	
			for(long i=1; i<n; i+=4) {
				fList.add(i);
				if(i+1 < n && i+2 < n && i+3<=n){
					sList.add(i+1);
					sList.add(i+2);
					fList.add(i+3);
				}
			}
		} else {
			fList.add(1L);
			fList.add(2L);
			sList.add(3L);
			for(long i=4; i<n; i+=4) {
				sList.add(i);
				if(i+1 < n && i+2 < n && i+3<=n){
					fList.add(i+1);
					fList.add(i+2);
					sList.add(i+3);
				}
			}
		}
		System.out.println("YES");
		System.out.println(fList.size());
		for(long val: fList) {
			System.out.print(val + " ");
		}
		System.out.print("\n");
		System.out.println(sList.size());
		for(long val: sList) {
			System.out.print(val + " ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		printSets(n);
	}
}