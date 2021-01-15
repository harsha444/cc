package google.getwellpreparedques.arraysandstrings;

import java.util.*;

public class ValidParentheses {
	public static boolean isValid(String s) {
		char[] ch = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for(char c: ch) {
			if(c=='(' || c=='{' || c=='[') {
				stack.push(c);
			} else if(!stack.isEmpty()){
				char top = stack.pop();
				if(c==')') {
					if(top!='(') {
						return false;
					}
				} else if(c=='}') {
					if(top!='{') {
						return false;
					}
				} else if(c==']') {
					if(top!='[') {
						return false;
					}
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(isValid(s));
	}
}