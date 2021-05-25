package topquestions.easy.tree;

public class SortedArrayToBST {
    private static TreeNode sortedArrayToBSTUtil(int[] nums, int s, int e) {
        if(s>e) {
            return null;
        }
        int mid = (s+e)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTUtil(nums, s, mid-1);
        root.right = sortedArrayToBSTUtil(nums, mid+1, e);
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTUtil(nums, 0, nums.length);
    }

    public static void main(String[] args) {

    }
}
