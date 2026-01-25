package java.leetcode.binarytree.pathsum;

// 112. Path Sum
// https://leetcode.com/problems/path-sum/
/*
InOrder -> DFS
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
//  [5,4,8,11,null,13,4,7,2,null,null,null,1]

        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node11 = new TreeNode(11, node7, node2);
        TreeNode node4 = new TreeNode(4, node11, null);

        TreeNode node1 = new TreeNode(1);
        TreeNode node4r = new TreeNode(4, null, node1);
        TreeNode node13 = new TreeNode(13);
        TreeNode node8 = new TreeNode(8, node13, node4r);

        TreeNode node5 = new TreeNode(5, node4, node8);

        boolean isHasPathSum = dfs(node5, 0, 22);
        System.out.println("isHasPathSum = " + isHasPathSum);
    }

    private boolean dfs(TreeNode root, Integer curSum, int targetSum){
        if (root == null){
            return false;
        }

        curSum += root.val;

        if (root.left == null && root.right== null){
            return curSum == targetSum;
        }

        return dfs(root.left, curSum, targetSum) || dfs(root.right, curSum, targetSum);
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
