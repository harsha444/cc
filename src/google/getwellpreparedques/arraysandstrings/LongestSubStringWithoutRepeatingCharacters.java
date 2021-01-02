package google.getwellpreparedques.arraysandstrings;

import java.util.*;

public class LongestSubStringWithoutRepeatingCharacters {
    public static int getResponse(String input) {
        Map<Character, Integer> m = new HashMap<>();
        int ans = 0;
        int i = 0;
        for (int j = 0; j < input.length(); j++) {
            char currChar = input.charAt(j);
            if (m.containsKey(currChar)) {
                i = j + 1;
            }
            ans = Math.max(ans, j - i + 1);
            m.put(input.charAt(j), j);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(getResponse(input));
    }
}