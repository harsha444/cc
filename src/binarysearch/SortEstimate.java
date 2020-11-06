package binarysearch;

import java.util.Scanner;

/*
 * TopCoder Problem
 * */

public class SortEstimate {
    static double f(double c, double mid) {
        return c * mid * Math.log(mid) / Math.log(2);
    }

    public static double howMany(int c, int time) {
        double min = 0;
        double max = 1e+20;
        // Alternatively while(max-min>1e-20 && flag>0)
        for (int i = 0; i < 500; i++) {
            double mid = (max + min) / 2;
            if (f(c, mid) <= time) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return (min + max) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            int time = sc.nextInt();
            System.out.println(howMany(c, time));
        }
    }
}
