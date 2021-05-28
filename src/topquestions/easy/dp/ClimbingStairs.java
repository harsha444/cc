package topquestions.easy.dp;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        int s = 1;
        int e = 2;
        int temp;
        if (n == s) {
            return s;
        }
        if (n == e) {
            return e;
        }
        for (int i = 3; i <= n; i++) {
            temp = e;
            e = s+e;
            s = temp;
        }
        return e;
    }

    public static void main(String[] args) {

    }
}
