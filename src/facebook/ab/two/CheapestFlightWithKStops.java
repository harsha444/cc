package facebook.ab.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightWithKStops {
    class Pair {
        int city;

        int cost;

        public Pair(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    class City {
        int city;

        int costFromSource;

        int distanceFromSource;

        public City(int city, int costFromSource, int distanceFromSource) {
            this.city = city;
            this.costFromSource = costFromSource;
            this.distanceFromSource = distanceFromSource;
        }
    }

    private int findCheapestFlight(int n, int[][] flights, int k, int src, int dst) {
        if (n < 1 || flights.length == 0 || k < 0) {
            return -1;
        }
        //create graph
        //seen map with city<>distance
        //priority queue with min cost
        List<List<Pair>> graph = new ArrayList<>();
        createGraph(flights, n, graph);
        Map<Integer, Integer> seen = new HashMap<>();
        PriorityQueue<City> pq = new PriorityQueue<>((City c1, City c2) -> c1.costFromSource - c2.costFromSource);
        pq.offer(new City(src, 0, 0));
        while (!pq.isEmpty()) {
            City curr = pq.poll();
            // continue if it is in seen and distance in seen is <= curr
            if (seen.containsKey(curr.city) && seen.get(curr.city) <= curr.distanceFromSource) {
                continue;
            }
            // put in seen
            seen.put(curr.city, curr.distanceFromSource);
            // return if we are at destination
            if (curr.city == dst) {
                return curr.costFromSource;
            }

        } return -1;
    }

    private void createGraph(int[][] flights, int n, List<List<Pair>> graph) {
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
