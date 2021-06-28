package educative.twopointers;

public class SquaringASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] squareArray = new int[nums.length];
        int endPointer = nums.length - 1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int squareAtStart = nums[start] * nums[start];
            int squareAtEnd = nums[end] * nums[end];
            if (squareAtStart > squareAtEnd) {
                squareArray[endPointer] = squareAtStart;
                start += 1;
                endPointer--;
            } else {
                squareArray[endPointer] = squareAtEnd;
                end -= 1;
                endPointer--;
            }
        }
        return squareArray;
    }

    public static void main(String[] args) {

    }
}
