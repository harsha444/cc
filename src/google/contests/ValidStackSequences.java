package google.contests;

import java.util.*;


public class ValidStackSequences {
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> s = new Stack<>();
		int curr = 0;
		for(int i=0; i<pushed.length; i++) {
			s.push(pushed[i]);
			while(!s.empty() && s.peek()==popped[curr]) {
				s.pop();
				curr+=1;
			}
		}

		return s.empty();
    }

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		int[] pushed = {1, 2, 3, 4, 5};
		int[] popped = {4, 5, 3, 2, 1};
		System.out.println(validateStackSequences(pushed, popped));
	}
}