////package facebook.slidingwindow;
//
//import java.util.*;
//
//public class NextLetter {
//	public char nextGreatestLetter(char[] letters, char target) {
//        int start = 0;
//        int end = letters.length - 1;
//        if(target >= letters[end]) {
//        	return letters[0];
//        }
//        if(target <= letters[start]) {
//        	return letters[end];
//        }
//        while(start<=end) {
//        	int middle = start + (end-start)/2;
//        	if(target < letters[middle]) {
//        		end = middle - 1;
//        	} else {
//        		start = middle + 1;
//        	}
//        }
//    return '1';
//    }
//
////	public static void main(String[] args) {
////		nextGreatestLetter(new char[] {"c","f","j"}, 'c');
////	}
//}