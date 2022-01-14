package facebook.ab.two;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MaxProfitInJobScheduling {
    class Job {
        int startTime;

        int endTime;

        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        dp.put(0, 0);
        for (int[] job : jobs) {
            int curMax = dp.floorEntry(job[0]).getValue() + job[2];
            if (curMax > dp.lastEntry().getValue()) {
                dp.put(job[1], curMax);
            }
        }
        return dp.lastEntry().getValue();
    }

    public static void main(String[] args) {

    }
}
