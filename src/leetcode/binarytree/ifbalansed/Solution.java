package leetcode.binarytree.ifbalansed;

// 110. Balanced Binary Tree
// https://leetcode.com/problems/balanced-binary-tree/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode root = arrayToNode(array);
    }


    public boolean isBalanced(TreeNode root) {
        int height = height(root);
        return height != -1;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }


    private TreeNode arrayToNode(Integer[] array) {
        TreeNode root = new TreeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i] != null) {
                addNode(root, new TreeNode(array[i]));
            }
        }
        return root;
    }

    private void addNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return;
        }

        if (root.val < node.val) {
            if (root.left == null) {
                root.left = node;
            } else {
                addNode(root.left, node);
            }
        } else if (root.val >= node.val) {
            if (root.right == null) {
                root.right = node;
            } else {
                addNode(root.right, node);
            }
        }
    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}