package facebook.top100;

import java.util.Arrays;

public class MaximumSwap {
    public static int maximumSwap(int num) {
        char[] c = Integer.toString(num).toCharArray();
        char[] minC = new char[c.length];
        char[] maxC = new char[c.length];
        char min = c[0];
        char max = c[c.length - 1];
        for (int i = 0; i < minC.length; i++) {
            if (c[i] < min) {
                min = c[i];
            }
            minC[i] = min;
        }
        for (int i = maxC.length - 1; i >= 0; i--) {
            if (c[i] > max) {
                max = c[i];
            }
            maxC[i] = max;
        }
        int minIndex = 0;
        for (int i = 0; i < c.length; i++) {
            if (minC[i] < maxC[i]) {
                minIndex = i;
                break;
            }
        }
        int maxNum = maxC[minIndex];
        int maxIndexLast = minIndex;
        while (maxIndexLast < c.length && maxC[maxIndexLast] == maxNum) {
            maxIndexLast++;
        }
        maxIndexLast -= 1;
        char temp = c[minIndex];
        c[minIndex] = c[maxIndexLast];
        c[maxIndexLast] = temp;
        return Integer.parseInt(new String(c));
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(98368));
    }
}
