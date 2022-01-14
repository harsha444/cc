package facebook.lc;

class TreeNode {
    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }
}

public class DiameterOfTree {
    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lD = diameterOfBinaryTree(root.left);
        int rD = diameterOfBinaryTree(root.right);
        int diameterHere = lD + rD;
        diameter = Math.max(diameterHere, diameter);
        return Math.max(lD, rD) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
    }
}
