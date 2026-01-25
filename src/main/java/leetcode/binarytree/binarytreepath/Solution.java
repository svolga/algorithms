package java.leetcode.binarytree.binarytreepath;

import java.util.ArrayList;
import java.util.List;

// 257. Binary Tree Paths
// https://leetcode.com/problems/binary-tree-paths/description/
public class Solution {

    List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, null, node5);
/*
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node2, node3);
*/

        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20);
        TreeNode node10 = new TreeNode(10, node7, node20);

        TreeNode root = new TreeNode(1, node2, node10);

        list = binaryTreePaths(root);
        System.out.println(list);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, String.valueOf(root.val));
        return list;
    }

    private void dfs(TreeNode root, String parent) {

        if (root == null) {
            return;
        }

        if (null != root.left) {
            dfs(root.left, parent + "->" + root.left.val);
        }

        if (null != root.right) {
            dfs(root.right, parent + "->" + root.right.val);
        }

        if ((root.left == null) && (root.right == null)) {
            list.add(parent);
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
