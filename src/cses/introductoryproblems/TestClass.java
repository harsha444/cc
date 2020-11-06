package cses.introductoryproblems;

// Java code to illustrate the entrySet() method
import java.util.*;

public class TestClass {
    public static void main(String[] args)
    {

        // Creating an empty HashMap
        HashMap<String, String> hash_map = new HashMap<String, String>();

        // Mapping int values to string keys
        hash_map.put("Geeksy", "10");
        hash_map.put("4", "15");
        hash_map.put("Geeks", "20");
        hash_map.put("Welcomes", "25");
        hash_map.put("You", "30");
        System.out.println(hash_map.containsKey("Geeksy"));

        for (Map.Entry<String, String> entry : hash_map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            if(entry.getKey().equals("Welcomes")) {
                break;
            }
        }

        hash_map.put("Test", "10");

        System.out.println("Mappings are: " + hash_map);

    }
}
