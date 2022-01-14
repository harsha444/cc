package facebook.top100;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] response = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            response[i] = pq.poll();
            i++;
        }
        return response;
    }

    public static void main(String[] args) {

    }
}
