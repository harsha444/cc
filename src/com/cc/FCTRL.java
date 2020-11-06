package com.cc;

import java.util.Scanner;

public class FCTRL {
    public static void main(String[] args) throws java.lang.Exception{
        int count;
        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int targetNumber = scanner.nextInt();
            System.out.println(trailingZeros(targetNumber));
        }
    }

    public static int trailingZeros(int n) {
        int result = 0;
        while (n >= 5) {
            result += (n / 5);
            n /= 5;
        }
        return result;
    }
}
