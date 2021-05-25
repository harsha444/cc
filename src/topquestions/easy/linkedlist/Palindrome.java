package topquestions.easy.linkedlist;


import java.util.*;
/**
 * 1->2->3->2->1
 * len=5
 * 123
 */
public class Palindrome {

	private static int getLen(ListNode head) {
		ListNode temp = head;
		int len = 0;
		while(temp!=null) {
			len += 1;
			temp = temp.next;
		}
		return len;
	}

	public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> s = new Stack<>();
        int len = getLen(head);
        int skip = 0;
        if(len%2!=0) {
        	skip = 1;
        }
        int i = 0;
        for(; i<len/2; i++) {
        	s.push(temp.val);
        	temp = temp.next;
        }
        if(skip==1) {
        	temp = temp.next;
        	i+=1;
        }
        for(; i<len; i++) {
        	if(s.pop()!=temp.val) {
        		return false;
        	}
        	temp = temp.next;
        }

        return true;
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
        head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(head));
	}
}