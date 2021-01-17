package google.getwellpreparedques.arraysandstrings;

import java.util.*;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for(char ch: S.toCharArray()) {
        	if(ch=='#' && !sStack.isEmpty()) {
        		sStack.pop();
        	} else if (ch != '#') {
        		sStack.push(ch);
        	}
        }

        for(char ch: T.toCharArray()) {
        	if(ch=='#' && !tStack.isEmpty()) {
        		tStack.pop();
        	} else if (ch != '#') {
        		tStack.push(ch);
        	}
        }
        if(sStack.size()!=tStack.size()) {
            return false;
        }
        return sStack.toString().equals(tStack.toString());
    }

    public static void main(String[] args) {
        String a = "ab#c";
        String b = "#ab#c";
        System.out.println(backspaceCompare(a, b));
    }
}
