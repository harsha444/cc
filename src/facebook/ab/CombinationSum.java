package facebook.ab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), target, candidates, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int remain, int[] candidates, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            backtrack(list, tempList, remain - candidates[i], candidates, i);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
