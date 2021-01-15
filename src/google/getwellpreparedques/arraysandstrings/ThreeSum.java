package google.getwellpreparedques.arraysandstrings;

import java.util.*;

public class ThreeSum {
	public static List<List<Integer>> twoSum(int start, int[] nums, int target) {
		Map<Integer, Integer> m = new HashMap<>();
		List<List<Integer>> response = new ArrayList<>();
		for(int i=start; i<nums.length; i++) {
			int complement = target - nums[i];
			if(m.containsKey(complement)) {
				response.add(Arrays.asList(nums[i], complement));
			}
			m.put(nums[i], 1);
		}
		return response;
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		if(nums.length<3) {
			return Collections.emptyList();
		}
		Set<Integer> s = new HashSet<>();
		Set<List<Integer>> responseSet = new HashSet<>();
		for(int i=0; i<nums.length-2; i++) {
			if(s.add(nums[i])) {
				int curr = nums[i];
				int complement = -curr;
				List<List<Integer>> twoElements = twoSum(i+1, nums, complement);
				for(List<Integer> li: twoElements) {
					List<Integer> triplet = Arrays.asList(curr, li.get(0), li.get(1));
					Collections.sort(triplet);
					responseSet.add(triplet);
				}
				s.add(curr);
			}
		}
		return new ArrayList(responseSet);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i+=1) {
			a[i] = sc.nextInt();
		}
		List<List<Integer>> response = threeSum(a);
		System.out.print(response);
	}
}