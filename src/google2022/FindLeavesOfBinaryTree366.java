package google2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLeavesOfBinaryTree366 {
    private List<List<Integer>> response;

    private int heightUtil(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = heightUtil(root.left);
        int rightHeight = heightUtil(root.right);
        int currHeight = leftHeight + rightHeight + 1;
        if(response.get(currHeight) == null) {
            response.add(new ArrayList<>());
        }
        response.get(currHeight).add(root.val);
        return currHeight;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        response = new ArrayList<>();
        heightUtil(root);
        return response;
    }

    public static void main(String[] args) {

    }
}
