package fb.trees;

public class MaximumSumPath {
    int maxSum = Integer.MIN_VALUE;

    private int maxPathUtil(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = maxPathUtil(root.left);
        int rightSum = maxPathUtil(root.right);
        int maxInLAndR = Math.max(leftSum, rightSum);
        int maxWithCurr = Math.max(maxInLAndR + root.val, root.val);
        int maxAll = Math.max(maxWithCurr, leftSum + rightSum + root.val);
        maxSum = Math.max(maxSum, maxAll);
        return maxWithCurr;
    }

    public int maxPathSum(TreeNode root) {
        maxPathUtil(root);
        return maxSum;
    }
}
