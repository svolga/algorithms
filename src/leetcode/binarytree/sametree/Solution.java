package leetcode.binarytree.sametree;


// 100. Same Tree
// https://leetcode.com/problems/same-tree/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {

        TreeNode node12 = new TreeNode(1);
        TreeNode node11 = new TreeNode(1, node12, null);

        TreeNode node22 = new TreeNode(1);
        TreeNode node21 = new TreeNode(1, null, node22);

        boolean isSame = isSameTree(node11, node21);
        System.out.println(isSame);
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val == q.val) {
            boolean isSameLeft = isSameTree(p.left, q.left);
            boolean isSameRight = isSameTree(p.right, q.right);
            return isSameLeft && isSameRight;
        }
        return false;
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
