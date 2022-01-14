package facebook.ab;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortIntegersByPowerValue {
    class Item {
        int num;

        int power;

        public Item(int num, int power) {
            this.num = num;
            this.power = power;
        }
    }

    Map<Integer, Integer> m = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        PriorityQueue<Item> pq = new PriorityQueue<>((a, b) -> b.power == a.power ? b.num - a.num : b.power - a.power);
        for (int i = lo; i < hi; i++) {
            int power = getPower(i);
            pq.add(new Item(i, power));
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.remove().num;
    }

    private int getPower(int n) {
        if (n == 1) {
            return 0;
        }
        if (m.containsKey(n)) {
            return m.get(n);
        }
        int power;
        if (n % 2 == 0) {
            power = 1 + getPower(n / 2);
        } else {
            power = 1 + getPower((3 * n) + 1);
        }
        m.put(n, power);
        return power;
    }

    public static void main(String[] args) {

    }
}
