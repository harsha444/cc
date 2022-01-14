package facebook.top100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }

    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        return wordDict;
    }

    public static void main(String[] args) {

    }
}
