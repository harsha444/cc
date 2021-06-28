package leetcode.june;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
    List<int[]> calendar = new ArrayList<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        boolean canBeBooked = true;
        for (int[] slot : calendar) {
            if (Math.max(slot[0], start) < Math.min(slot[1], end)) {
                return false;
            }
        }
        calendar.add(new int[] { start, end });
        return canBeBooked;
    }
}
