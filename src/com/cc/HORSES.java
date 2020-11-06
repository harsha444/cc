package com.cc;

import java.util.Arrays;
import java.util.Scanner;

public class HORSES {
    public static void main(String[] args) throws java.lang.Exception {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int sz = scanner.nextInt();
            int a[] = new int[sz];
            for (int j = 0; j < sz; j++) {
                a[j] = scanner.nextInt();
            }
            Arrays.sort(a);
            int result = 999999999;
            for (int k = 1; k < sz; k++) {
                if (a[k] - a[k - 1] < result) {
                    result = a[k] - a[k - 1];
                }
            }
            System.out.println(result);
        }
    }
}
