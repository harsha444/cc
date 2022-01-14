package facebook.handpicked;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    int size;

    Queue<Integer> queue;

    int sum;

    public MovingAverage(int k) {
        size = k;
        queue = new LinkedList<>();
        sum = 0;
    }

    public int next(int val) {
        if(queue.size()==size) {
            queue.poll();
        }
        sum+=val;
        queue.add(val);
        return sum/queue.size();
    }

    public static void main(String[] args) {

    }
}
