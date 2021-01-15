package google.contests;

import java.util.Scanner;

public class MinimumJobTime {
	public static boolean check(int[] jobs, int k, int n, int mid) {
		int count = 0;
		int sum = 0;
		for (int i=0; i<n; i++) {
			if(jobs[i] > mid) {
				return false;
			}
			sum += jobs[i];
			if (sum > mid) { 
	            count++; 
	            sum = jobs[i];
	        } 
		}
		count += 1;
		if(count <= k) {
			return true;
		}
		return false;
	}
	public static int minimumTimeRequired(int[] jobs, int k) {
		int start = 0;
		int len = jobs.length;
		int end = 0;
		for(int i=0; i<len; i++) {
			end += jobs[i];
		}

		int answer = 0;

		while(start<=end) {
			int mid = (start+end)/2;
			if(check(jobs, k, len, mid)) {
				answer = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return answer;
    }

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(minimumTimeRequired(a, k));
	}
}