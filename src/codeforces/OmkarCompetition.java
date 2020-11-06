package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class OmkarCompetition {
    public static int[] getResponse(int k) {
        int[] arr = new int[k];
        for(int i=0; i<k; i++) {
            arr[i] = 1;
        }
        return arr;
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k;
            k = sc.nextInt();
            int[] resp = getResponse(k);
            for(int j: resp) {
                System.out.print(j + " ");
            }
        }
    }
}
