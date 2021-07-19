package linkedlist;

public class HappyNumber {
    private static int getSumUtil(int n) {
        int sum = 0;
        while (n > 0) {
            int q = n % 10;
            int r = n / 10;
            sum = sum + (q * q);
            n = r;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int hare = n;
        int tortoise = n;
        while (hare != 1 && getSumUtil(hare) != 1) {
            hare = getSumUtil(getSumUtil(hare));
            tortoise = getSumUtil(tortoise);
            if (hare == tortoise) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
