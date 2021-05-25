package topquestions.easy.tree;

import java.util.*;

class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
    }
}

public class MaximumDepth {
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = height(root.left) + 1;
        int r = height(root.right) + 1;
        return Math.max(l, r);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.right = new TreeNode(3);
        System.out.println(height(root));
    }
}
