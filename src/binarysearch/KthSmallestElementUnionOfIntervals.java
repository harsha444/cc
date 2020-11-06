package binarysearch;

import java.util.Scanner;
/*
* http://geeksforgeeks.org/find-k-th-smallest-element-in-given-n-ranges/?ref=rp
* */
public class KthSmallestElementUnionOfIntervals {
    static int nthElement(int[] lowerBound, int[] upperBound, int k) {
        int sz = lowerBound.length;
        int[] total = new int[sz + 1];
        total[0] = 0;
        for (int i = 1; i < sz + 1; i++) {
            total[i] += total[i - 1] + (upperBound[i - 1] - lowerBound[i - 1]) + 1;
        }
        int start = 0;
        int end = sz;
        int index = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (total[mid] == k) {
                index = mid;
                break;
            }
            if (total[mid] < k) {
                start = mid + 1;
            } else if (total[mid] > k) {
                end = mid;
            }
        }
        index = index != -1 ? index : start;
        int lo = lowerBound[index - 1];
        int hi = upperBound[index - 1];
        int x = k - total[index - 1];
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if ((mid - lowerBound[index - 1]) == x) {
                return mid;
            } else if ((mid - lowerBound[index - 1]) > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] l = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            h[j] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(nthElement(l, h, k));
    }
}
