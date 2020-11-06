package geeks.mustdoquestions.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CountTheTriplets {
    public static int countTriplets(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        int response = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int start = i + 1;
            int end = arr.length - 1;
            while (start < end) {
                if (arr[start] + arr[end] == arr[i]) {
                    response += 1;
                } else if (arr[start] + arr[end] < arr[i]) {
                    start += 1;
                } else {
                    end -= 1;
                }
            }
        }
        return response != 0 ? response : -1;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int arrSize = sc.nextInt();
            Integer[] arr = new Integer[arrSize];
            for (int j = 0; j < arrSize; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(countTriplets(arr));
        }
    }
}
