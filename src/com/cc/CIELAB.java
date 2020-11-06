package com.cc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CIELAB {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bufferedReader.readLine().split(" ");
        String firstNumber = line[0];
        String secondNumber = line[1];
        int n1 = Integer.parseInt(firstNumber);
        int n2 = Integer.parseInt(secondNumber);
        int res = Math.abs(n1 - n2);
        if((res+1)%10==0) {
            res -= 1;
        } else {
            res += 1;
        }
        System.out.println(res);
    }
}
