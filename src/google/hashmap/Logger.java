package google.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Logger {
	Map<String, Integer> m;

	public Logger() {
		this.m = new HashMap<>();
	}

	public boolean shouldPrintMessage(int timestamp, String message) {
		if(!m.containsKey(message) || (m.containsKey(message) && m.get(message)<=timestamp)) {
			m.put(message, timestamp+10);
			return true;
		}
        return false;
    }

	public static void main(String[] args) {
		Logger logger = new Logger();
		System.out.println(logger.shouldPrintMessage(1, "foo"));
		System.out.println(logger.shouldPrintMessage(11, "foo"));
	}
}