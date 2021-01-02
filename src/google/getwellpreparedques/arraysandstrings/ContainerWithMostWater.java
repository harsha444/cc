package google.getwellpreparedques.arraysandstrings;

import java.util.*;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
        int s = 0;
        int e = height.length - 1;
        int resp = 0;
        while(s<e) {
        	if(height[s] < height[e]) {
        		resp = Math.max(resp, (e-s)*height[s]);
        		s++;
        	} else {
        		resp = Math.max(resp, (e-s)*height[e]);
        		e--;
        	}
        }
        return resp;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] height = new int[n];
		for(int i=0; i<n; i++) {
			height[i] = sc.nextInt();
		}
		System.out.println(maxArea(height));
	}
}