package cses.introductoryproblems;

import java.util.*;

public class WeirdAlgorithm {

	public static void getResponse(long n) {
		System.out.print(n + " ");
		if(n==1) {
			return;
		}
		if(n%2==0) {
			n=n/2;
		} else {
			n = (n*3)+1;
		}
		getResponse(n);
	}

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	long n = sc.nextInt();
    	getResponse(n);
    }
}
