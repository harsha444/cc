package google.contests;

import java.util.*;
import java.io.*;


public class TotalMoney {
	public static int totalMoney(int n) {
		int div = n/7;
		int mod = n%7;
		int temp = 0;
		int start = div+1;

		for(int i=0; i<mod; i++){
			temp+=start;
			start+=1;
		}

		if(n<7) {
			return temp;
		}

		if(mod == 0) {
			return (div*28)+((div-1)*7);
		}

		if(div>=3) {
			int a = div*28;
			for(int i=1; i<=div; i++) {
				a+=(7*i);
			}
			return a + temp;
		} else {
			return (div*28)+((div-1)*7) + temp;
		}

    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(totalMoney(n));
	}
}