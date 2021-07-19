package trees;

public class ValidateBST {
    public boolean validate(TreeNode root, Integer low, Integer high) {
        if(root==null) {
            return true;
        }
        if((low!=null && root.val<=low) || (high!=null&&root.val>=high)) {
            return false;
        }
        return validate(root.left, root.val, high) && validate(root.right, low, root.val);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
}
