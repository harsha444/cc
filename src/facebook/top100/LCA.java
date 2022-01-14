package facebook.top100;

class TreeNode {
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

    private TreeNode(int val) {
        this.val = val;
    }
}

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null && r == null) {
            return null;
        }
        if (l != null && r != null) {
            return root;
        }
        return l == null ? r : l;
    }

    public static void main(String[] args) {

    }
}
