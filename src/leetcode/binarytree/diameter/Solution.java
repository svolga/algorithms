package leetcode.binarytree.diameter;

// 543. Diameter of Binary Tree
// https://leetcode.com/problems/diameter-of-binary-tree/description/?envType=daily-question&envId=2024-02-27
public class Solution {

    private int result = 0;

    public static void main(String[] args) {
        //new Solution().run(args);
    }

    /*private void run(String[] args) {

        diameter =

    }
*/

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return result;
    }

    private int diameter(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = diameter(root.left);
        int right = diameter(root.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
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