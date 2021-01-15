package google.getwellpreparedques.arraysandstrings;

import java.util.*;

public class MultiplyStrings {
	public static String multiply(String num1, String num2) {
        int num1Len = num1.length();
        int num2Len = num2.length();
        if(num2Len > num1Len) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
            num1Len = num1.length();
            num2Len = num2.length();
        }

        int[] res = new int[num1Len*num2Len];
        int resLength = res.length;
        char[] num1CharArray = num1.toCharArray();
        char[] num2CharArray = num2.toCharArray();
        for(int j=num2Len-1; j>=0; j--) {
        	for(int i=num1Len-1; i>=0; i--) {
        	    int index = resLength-(resLength-i);
        		res[index] = res[index] + (num1CharArray[i]-'0' * num2CharArray[j]-'0');
        		if(res[index]>=10) {
        			res[index] = res[index]/10;
        			res[index-1] = 1;
        		}
        	}
        }
        return Arrays.toString(res);
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String y = sc.nextLine();
		String z = sc.nextLine();
		System.out.print(multiply(y, z));
	}
}