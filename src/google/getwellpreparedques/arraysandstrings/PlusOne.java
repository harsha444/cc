package google.getwellpreparedques.arraysandstrings;

import java.util.*;

public class PlusOne {
	public static int[] plusOne(int[] digits) {
		int step =  0;
		for(int i=digits.length-1; i>=0; i--) {
			if(i==digits.length-1) {
				digits[i] += 1;
			} else {
				digits[i] += step;
			}
			if(digits[i]>=10) {
				digits[i] = 0;
				step = 1;
			} else {
				step = 0;
				break;
			}
		}
		if(step == 0) {
			return digits;
		} else {
			int[] resp = new int[digits.length+1];
			resp[0] = 1;
			for(int i=0; i<digits.length; i++) {
				resp[i+1] = digits[i];
			}
			return resp;
		}
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(Arrays.toString(plusOne(a)));
	}
}