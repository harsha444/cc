package fb.trees;

public class FlattenBST {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root;
        while (temp != null) {
            if (temp.left != null) {
                TreeNode rightNode = temp.left;
                while (rightNode.right != null) {
                    rightNode = rightNode.right;
                }
                rightNode.right = temp.right;
                temp.right = temp.left;
                temp.left = null;
            }
            temp = temp.right;
        }
    }

    public static void main(String[] args) {

    }
}
