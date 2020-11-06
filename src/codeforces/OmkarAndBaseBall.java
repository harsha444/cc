package codeforces;

import java.util.Scanner;

public class OmkarAndBaseBall {
    public static void main(String[] args) {
        long n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 1; i <= n; i++) {
            int arrSize = sc.nextInt();
            int[] arr = new int[arrSize];
            for (int j = 0; j < arrSize; j++) {
                arr[j] = sc.nextInt();
                if (j != arr[j]) {
                    flag = true;
                }
                if (flag && j == arr[j]) {
                    flag1 = true;
                }
                if (flag1 && j != arr[j]) {
                    flag2 = true;
                }
            }
            if (flag2) {
                System.out.println(2);
            } else if (flag) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
