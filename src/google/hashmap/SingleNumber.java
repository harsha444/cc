package google.hashmap;

import java.util.*;

public class SingleNumber {
	public static int singleNumber(int[] nums) {
		Map<Integer, Integer> m = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			m.put(nums[i], m.getOrDefault(nums[i], 0)+1);
		}
		for(Map.Entry<Integer, Integer> it: m.entrySet()) {
			if(it.getValue()==1) {
				return it.getKey();
			}
		}
		return -1;
    }

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(a);
	}
}