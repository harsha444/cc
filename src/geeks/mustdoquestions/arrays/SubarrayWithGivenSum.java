package geeks.mustdoquestions.arrays;

import java.util.*;

public class SubarrayWithGivenSum {

	public static void getResponse(ArrayList<Integer> arr, int s) {
		HashMap<Integer, Integer> hashMap= new HashMap<>();
		int currSum = 0;
		int start = 0;
		int end = -1;
		for(int i=0; i<arr.size(); i++) {
			currSum += arr.get(i);
			if(currSum - s == 0) {
				start = 0;
				end = i;
				break;
			}
			if(hashMap.containsKey(currSum-s)) {
				start = hashMap.get(currSum-s)+1;
				end = i;
				break;
			}
			hashMap.put(currSum, i);
		}
		if(end == -1) {
			System.out.println(-1);
		} else {
			start+=1;
			end+=1;
			System.out.println(start + " " + end);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n--!=0) {
			ArrayList<Integer> inputArray = new ArrayList<>();
			int arraySize = sc.nextInt();
			int sumToFind = sc.nextInt();
			for(int i=0; i<arraySize; i++) {
				inputArray.add(sc.nextInt());
			}
			getResponse(inputArray, sumToFind);
		}
	}
} 