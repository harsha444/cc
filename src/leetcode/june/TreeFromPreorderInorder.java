package leetcode.june;

import java.util.HashMap;
import java.util.Map;

public class TreeFromPreorderInorder {
    int preOrderIndex = 0;

    Map<Integer, Integer> m = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }
        return constructTreeFromArray(preorder, 0, preorder.length - 1);
    }

    private TreeNode constructTreeFromArray(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }
        int curr = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(curr);
        root.left = constructTreeFromArray(preorder, l, m.get(curr) - 1);
        root.right = constructTreeFromArray(preorder, m.get(curr) + 1, r);
        return root;
    }

    public static void main(String[] args) {

    }
}
