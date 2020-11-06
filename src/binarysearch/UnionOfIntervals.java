package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

// https://community.topcoder.com/stat?c=problem_statement&pm=4823&rd=8074
public class UnionOfIntervals {
    public static int nthElement(int[] lowerBound, int[] higherBound, int k) {
        long lo = Arrays.stream(lowerBound).min().getAsInt();
        long hi = Arrays.stream(higherBound).max().getAsInt();
        k += 1;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long step = 0;
            for (int i = 0; i < lowerBound.length; i++) {
                if (lowerBound[i] <= mid) {
                    if (higherBound[i] < mid) {
                        step += (higherBound[i] - lowerBound[i]) + 1;
                    } else {
                        step += (mid - lowerBound[i]) + 1;
                    }
                }
            }
            if (step >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return (int) lo;
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
