package com.cc;

import java.util.Arrays;
import java.util.Scanner;

public class JOHNY {
    public static void main(String[] args) throws java.lang.Exception{
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int sz;
            sz = scanner.nextInt();
            int[] a = new int[sz];
            for (int j = 0; j < sz; j++) {
                a[j] = scanner.nextInt();
            }
            int uncleSong = scanner.nextInt()-1;
            int uncleSongLen = a[uncleSong];
            Arrays.sort(a);
            int res = 1;
            for(int k=0; k<sz; k++) {
                if(a[k] == uncleSongLen){
                    res = k+1;
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
