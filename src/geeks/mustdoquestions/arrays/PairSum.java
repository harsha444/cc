package geeks.mustdoquestions.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class PairSum {
    public static boolean printPairs(int[] arr, int n) {
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] + arr[end] == n) {
                return true;
            } else if (arr[start] + arr[end] < n) {
                start += 1;
            } else {
                end -= 1;
            }
        }
        return false;
    }

    public static boolean printPairsUsingHashMap(int[] arr, int n) {
        HashSet<Integer> s = new HashSet<>();
        for (int value : arr) {
            int temp = n - value;
            if (s.contains(temp)) {
                return true;
            }
            s.add(value);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        int n = 16;
        System.out.println(printPairs(arr, n));
        System.out.println(printPairsUsingHashMap(arr, n));
    }
}
