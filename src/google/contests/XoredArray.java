package google.contests;

import java.util.Arrays;
import java.util.Scanner;

public class XoredArray {
	public static int[] decode(int[] encoded, int first) {
		int[] resp = new int[encoded.length+1];
		resp[0] = first;
		for(int i=1; i<resp.length; i++) {
			resp[i] = resp[i-1]^encoded[i-1];
		}
		return resp;
    }

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(Arrays.toString(decode(a, sc.nextInt())));
	}
}