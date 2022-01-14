package facebook.lc;

public class MaxSwap {
    public static int maximumSwap(int num) {
        String s = Integer.toString(num);
        char[] arr = s.toCharArray();
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - '0' > arr[maxIndex] - '0') {
                maxIndex = i;
            }
        }
        char temp = arr[maxIndex];
        arr[maxIndex] = arr[0];
        arr[0] = temp;
        return Integer.parseInt(String.valueOf(arr));
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(9973));
    }
}
