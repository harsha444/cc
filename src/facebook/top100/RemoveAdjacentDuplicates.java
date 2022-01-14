package facebook.top100;

public class RemoveAdjacentDuplicates {
    public static String removeDuplicates(String s) {
        char[] response = s.toCharArray();
        int i = 0;
        for (int j = 0; j < s.length(); j++, i++) {
            response[i] = response[j];
            if (i > 0 && response[i] == response[i - 1]) {
                i -= 2;
            }
        }
        return new String(response, 0, i);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
