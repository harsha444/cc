package educative.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    static int maxVal = Integer.MIN_VALUE;
    private static void findPair(int[] arr, List<List<Integer>> triplets, int start, int end, int target) {
        while (start < end) {
            int currSum = arr[start] + arr[end];
            int currStartElement = arr[start];
            int currEndElement = arr[end];
            if (currSum == target) {
                triplets.add(Arrays.asList(-target, currStartElement, currEndElement));
                start += 1;
                end -= 1;
                while (start < end && currStartElement == arr[start]) {
                    start += 1;
                }
                while (start < end && currEndElement == arr[end]) {
                    end -= 1;
                }
            } else if (currSum < target) {
                maxVal = Math.max(maxVal, currSum);
                start += 1;
            } else {
                end -= 1;
            }
        }
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            findPair(arr, triplets, i + 1, arr.length - 1, -arr[i]);
        }
        return triplets;
    }

    public static void main(String[] args) {

    }
}
