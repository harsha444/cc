package trees;

public class DiameterOfTree {
    private int diameter = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        helper(root);
        return diameter;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDiameter = diameterOfBinaryTree(root.left);
        int rDiameter = diameterOfBinaryTree(root.right);
        int diameterHere = lDiameter + rDiameter;
        diameter = Math.max(diameterHere, diameter);
        return Math.max(lDiameter, rDiameter) + 1;
    }
}
