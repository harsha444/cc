package educative.twopointers;

public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        int[] resp = new int[] { -1, -1 };
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] + arr[end] < targetSum) {
                start++;
            } else if (arr[start] + arr[end] > targetSum) {
                end--;
            } else if (arr[start] + arr[end] == targetSum) {
                resp = new int[] { start, end };
                return resp;
            }
        }
        return resp;
    }
}
