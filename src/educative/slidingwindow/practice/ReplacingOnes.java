package educative.slidingwindow.practice;

import java.util.HashMap;
import java.util.Map;

public class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int start = 0;
        int maxLen = 0;
        int maxOnesInAWindow = 0;
        Map<Integer, Integer> intFrequency = new HashMap<>();
        for (int end = 0; end < arr.length; end++) {
            int currNum = arr[end];
            if (currNum == 1) {
                maxOnesInAWindow += 1;
            }
            if (end - start + 1 - maxOnesInAWindow > k) {
                if (arr[start] == 1) {
                    maxOnesInAWindow--;
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
