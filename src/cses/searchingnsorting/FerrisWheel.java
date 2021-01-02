 package cses.searchingnsorting;

import java.util.*;

public class FerrisWheel {
	public static void main(String[] args) {
		long n, x;
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		x = sc.nextLong();
		int[] p = new int[(int)2e5];
		for(int i=0; i<n; i++) {
			p[i] = sc.nextInt();
		}
		Arrays.sort(p, 0, (int)n);
		long ans = 0;
		for(int i=0,j=(int)n-1; i<j; ) {
			while(i<j && p[i]+p[j]>x) {
				--j;
			}
			if(i>=j) {
				break;
			}
			ans+=1;
			++i;
			--j;
		}
		System.out.println(n-ans);
	}
}