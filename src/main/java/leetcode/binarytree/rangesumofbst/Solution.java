package java.leetcode.binarytree.rangesumofbst;

// 938. Range Sum of BST
// https://leetcode.com/problems/range-sum-of-bst/description/

public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {

    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
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