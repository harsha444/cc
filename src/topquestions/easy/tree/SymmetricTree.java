package topquestions.easy.tree;

public class SymmetricTree {
    private static boolean isSymmetricUtil(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        if (leftRoot == null || rightRoot == null) {
            return false;
        }
        return leftRoot.val == rightRoot.val && isSymmetricUtil(leftRoot.left, rightRoot.right) && isSymmetricUtil(leftRoot.right, rightRoot.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return isSymmetricUtil(root.left, root.right);
    }

    public static void main(String[] args) {

    }
}
