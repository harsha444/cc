package com.cc;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String test = "ABC";
        test = test.replaceAll("D", "1");
        System.out.println(test);
        while (true) {
            int input = scanner.nextInt();
            if(input == 42) {
                break;
            } else {
                System.out.println(input);
            }
        }
    }
}
