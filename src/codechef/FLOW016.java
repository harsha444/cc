package codechef;

import java.util.Scanner;

public class FLOW016 {
    public static long gcd(long a, long b) {
        if (b % a == 0) {
            return a;
        }
        return gcd(b % a, a);
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long g = gcd(a, b);
            long l = a * (b / g);
            System.out.println(g + " " + l);
        }
    }
}
