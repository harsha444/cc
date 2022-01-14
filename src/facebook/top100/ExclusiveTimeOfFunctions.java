package facebook.top100;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Log {
    int id;

    boolean isStart;

    int time;

    public Log(String log) {
        String[] args = log.split(":");
        id = Integer.parseInt(args[0]);
        isStart = args[1].equals("start");
        time = Integer.parseInt(args[2]);
    }
}

public class ExclusiveTimeOfFunctions {
    public static int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log> stack = new Stack<>();
        int[] result = new int[n];
        for (String log : logs) {
            Log currLog = new Log(log);
            if (currLog.isStart) {
                stack.push(currLog);
            } else {
                Log top = stack.pop();
                result[currLog.id] += (currLog.time - top.time + 1);
                if (!stack.isEmpty()) {
                    result[stack.peek().id] -= (currLog.time - top.time + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exclusiveTime(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"))));
    }
}
