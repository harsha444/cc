package topquestions.easy.tree;

public class TreeHeight {
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
