package codeforces;

import java.util.Scanner;

public class OmkarLastMathClass {
    public static String maxFactor(long k) {
        String response = "";
        long highestFactor = 1;
        for (long i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                highestFactor = Math.max(highestFactor, Math.max(i, k / i));
            }
        }
        response += highestFactor + " " + (k - highestFactor);
        return response;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            System.out.println(maxFactor(x));
        }
    }
}
