package google2022;

public class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

    private TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private TreeNode() {
    }
}
