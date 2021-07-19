package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> response = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            while (currSize > 0) {
                TreeNode curr = queue.poll();
                levelList.add(curr.val);
                if(curr.right!=null) {
                    queue.add(curr.right);
                }
                if(curr.left!=null) {
                    queue.add(curr.left);
                }
                currSize -= 1;
            }
            response.add(levelList);
        }
        List<Integer> finalResp = new ArrayList<>();
        for(List<Integer> item: response) {
            finalResp.add(item.get(item.size()-1));
        }
        return response;
    }
}
