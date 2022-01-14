package facebook.top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    private void util(TreeNode root, TreeMap<Integer, List<Integer>> map, int level) {
        if (root == null) {
            return;
        }
        if (Objects.isNull(map.get(level))) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(root.val);
        util(root.left, map, level - 1);
        util(root.right, map, level + 1);
    }

    public List<List<Integer>> verticalOrderDFS(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        util(root, map, 0);
        return new ArrayList<>(map.values());
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        queue.add(root);
        cols.add(0);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            int currCol = cols.poll();
            map.putIfAbsent(currCol, new ArrayList<>());
            map.get(currCol).add(currNode.val);
            if (currNode.left != null) {
                queue.add(currNode.left);
                cols.add(currCol - 1);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
                cols.add(currCol + 1);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

    }
}
