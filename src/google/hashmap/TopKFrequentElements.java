package google.hashmap;

import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] response = new int[k];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey()) : Integer.compare(b.getValue(), a.getValue()));

        for (Map.Entry<Integer, Integer> it : m.entrySet()) {
            pq.add(it);
        }

        for (int i = 0; i < k; i++) {
            response[i] = pq.poll().getKey();
        }
        return response;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] response = topKFrequent(a, k);
        for (int i = 0; i < response.length; i++) {
            System.out.println(response[i]);
        }
    }
}