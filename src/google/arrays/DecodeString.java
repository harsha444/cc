package google.arrays;

import java.util.*;

public class DecodeString {
	public static String decodeString(String s) {
		StringBuilder res = new StringBuilder();
		int k = 0;
		for(int i=0; i<s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				
			} else if (s.charAt(i) == '[') {

			} else if (s.charAt(i) == ']') {

			} else {

			}
		}
		return "";
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.print(decodeString(s));
	}
}