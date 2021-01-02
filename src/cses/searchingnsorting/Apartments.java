package cses.searchingnsorting;

import java.util.*;

public class Apartments {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Long> a = new ArrayList<>();
		ArrayList<Long> b = new ArrayList<>();
		long n,m,k;
		long result = 0;
		n = sc.nextLong();
		m = sc.nextLong();
		k = sc.nextLong();
		for(long i=0; i<n; i++) {
			a.add(sc.nextLong());
		}
		for(long i=0; i<m; i++) {
			b.add(sc.nextLong());
		}
		Collections.sort(a);
		Collections.sort(b);
		for(int i=0, j=0; i<n; i++) {
			while(j<m && b.get(j)<a.get(i)-k) {
				j++;
			}
			if(j<m && b.get(j) <= a.get(i)+k) {
				result += 1;
				j++;
			}
		}
		System.out.println(result);
	}
}