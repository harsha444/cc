package facebook.ab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapstFlightsWithK {
    class City {
        int city;

        int costFromSource;

        public City(int city, int costFromSource, int distanceFromSource) {
            this.city = city;
            this.costFromSource = costFromSource;
            this.distanceFromSource = distanceFromSource;
        }

        int distanceFromSource;
    }

    class Pair {
        int city;

        int cost;

        public Pair(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (n <= 1 || flights.length == 0 || k < 0) {
            return -1;
        }
        List<List<Pair>> graph = new ArrayList<>();
        // build graph
        buildGraph(graph, flights, n);
        // seen
        Map<Integer, Integer> seen = new HashMap<>();
        PriorityQueue<City> pq = new PriorityQueue<>((City c1, City c2) -> c1.costFromSource - c2.costFromSource);
        pq.offer(new City(src, 0, 0));
        while (!pq.isEmpty()) {
            City curr = pq.poll();
            if (seen.containsKey(curr.city) && seen.get(curr.city) <= curr.distanceFromSource) {
                continue;
            }
            seen.put(curr.city, curr.distanceFromSource);
            if (curr.city == dst) {
                return curr.costFromSource;
            }
            if (curr.distanceFromSource > k) {
                continue;
            }
            List<Pair> neighbours = graph.get(curr.city);
            for (Pair neighbour : neighbours) {
                pq.offer(new City(neighbour.city, curr.costFromSource + neighbour.cost, curr.distanceFromSource + 1));
            }
        }
        return -1;
    }

    private void buildGraph(List<List<Pair>> graph, int[][] flights, int n) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
    }

    public static void main(String[] args) {

    }
}
