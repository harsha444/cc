package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    static boolean check(int[] stalls, int cowsAvailable, int distance) {
        // distance is mid => distance for which number of cows required should be computed
        int cowsRequired = 1;
        int pos = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - pos >= distance) {
                pos = stalls[i];
                cowsRequired += 1;
                if (cowsAvailable == cowsRequired) {
                    return true;
                }
            }
        }
        return false;
    }

    static void binarySearch(int[] stalls, int stallsSize, int cowsAvailable) {
        int max = -1;
        Arrays.sort(stalls);
        int minDistance = stalls[1] - stalls[0];
        int maxDistance = stalls[stallsSize - 1] - stalls[0];
        while (minDistance < maxDistance) {
            int mid = minDistance + (maxDistance - minDistance) / 2;
            if (check(stalls, cowsAvailable, mid)) {
                if (max < mid) {
                    max = mid;
                }
                minDistance = mid + 1;
            } else {
                maxDistance = mid;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] stalls = new int[n];
            for (int j = 0; j < n; j++) {
                stalls[j] = sc.nextInt();
            }
            binarySearch(stalls, n, c);
        }
    }
}
