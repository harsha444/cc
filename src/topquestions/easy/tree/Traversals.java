package topquestions.easy.tree;

import java.util.*;

public class Traversals {
    public static ArrayList<Integer> inorderUtil(TreeNode A, ArrayList<Integer> list) {
        if (A == null) {
            return list;
        }
        inorderUtil(A.left, list);
        list.add(A.val);
        inorderUtil(A.right, list);
        return list;
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        return inorderUtil(A, new ArrayList<>());
    }

    public static ArrayList<Integer> iterativeInorder(TreeNode A) {
        ArrayList<Integer> response = new ArrayList<>();
        return response;
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> resp = new ArrayList<>();
        Queue<TreeNode> s = new LinkedList<>();
        s.add(root);
        while (!s.isEmpty()) {
            int currSize = s.size();
            List<Integer> subList = new ArrayList<>();
            while (currSize != 0) {
                TreeNode ele = s.poll();
                subList.add(ele.val);
                if (ele.left != null) {
                    s.add(ele.left);
                }
                if (ele.right != null) {
                    s.add(ele.right);
                }
                currSize -=1;
            }
            resp.add(subList);
            System.out.println();
        }
        return resp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(levelOrderTraversal(root));
    }
}
