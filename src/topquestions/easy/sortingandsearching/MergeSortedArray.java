package topquestions.easy.sortingandsearching;

import java.util.ArrayList;
import java.util.List;

/**
 * 12000
 * 1
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int s = 0;
        int e = 0;
        List<Integer> l = new ArrayList<>();
        while (s < m && e < n) {
            if (nums1[s] < nums2[e]) {
                l.add(nums1[s]);
                s++;
            } else {
                l.add(nums2[e]);
                e++;
            }
        }
        if (s == m) {
            while (e < n) {
                l.add(nums2[e]);
                e++;
            }
        } else {
            while (s < m) {
                l.add(nums1[s]);
                s++;
            }
        }
    }

    public static void main(String[] args) {

    }
}
