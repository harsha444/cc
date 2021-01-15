package google.hashmap;

import java.util.*;

public class DailyTemperature {
	public static int[] dailyTemperatures(int[] T) {
		int[] response = new int[T.length];
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<T.length; i++) {
			while(!s.isEmpty() && T[i]>T[s.peek()]) {
				response[s.peek()] = i-s.peek();
				s.pop();
			}
			s.push(i);
		}
		return response;
    }

	public static void main(String[] args) {
		int[] arr = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
		int[] resp = dailyTemperatures(arr);
		for(int i: resp) {
			System.out.println(i);
		}
	}
}