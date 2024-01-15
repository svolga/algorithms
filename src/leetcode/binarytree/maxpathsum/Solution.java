package leetcode.binarytree.maxpathsum;

// 124. Binary Tree Maximum Path Sum
// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

public class Solution {

    int maxPathSum;

    public static void main(String[] args) {
        new Solution().run(args);
    }


    private void run(String[] args){

    }

    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        pathSum(root);
        return maxPathSum;
    }

    private int pathSum(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftSum = Math.max(0, pathSum(root.left));
        int rightSum = Math.max(0, pathSum(root.right));

        maxPathSum = Math.max(maxPathSum, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
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