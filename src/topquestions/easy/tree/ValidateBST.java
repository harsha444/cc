package topquestions.easy.tree;

public class ValidateBST {
    private static boolean isValidBSTUtil(TreeNode root, Integer l, Integer h) {
        if(root==null) {
            return true;
        }
        if(root.val>l || root.val<h) {
            return false;
        }
        boolean lRes = isValidBSTUtil(root.left, l, root.val);
        boolean rRes = isValidBSTUtil(root.right, root.val, h);
        return lRes && rRes;
    }
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {

    }
}
