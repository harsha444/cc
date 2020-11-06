package cses.introductoryproblems;

import java.util.*;

public class Repetitions {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String request = sc.nextLine();
		int c = 0, res = 1;
		char l = 'A';
		for(char ch: request.toCharArray()) {
			if(ch==l) {
				++c;
				res = Math.max(c, res);
			} else {
				c=1;
				l=ch;
			}
		}
		System.out.println(res);
	}
}
