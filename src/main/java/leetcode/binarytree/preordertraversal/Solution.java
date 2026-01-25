package java.leetcode.binarytree.preordertraversal;

import java.util.ArrayList;
import java.util.List;

// 144. Binary Tree Preorder Traversal
// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        Integer[] array = {1, null, 2, 3};

        TreeNode root = createNode(0);
        for (Integer value : array) {
            if (value != null) {
                TreeNode node = createNode(value);
                insertNode(root, node);
            }
        }

        printTree(root);

        List <Integer> list = new ArrayList<>();
        dfs(root, list);
        print(list);
    }

    private void dfs(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    private void print(List<Integer> list) {
        System.out.println(list);
    }

    private void printTree(TreeNode root) {
        if (root.left != null) {
            printTree(root.left);
        }
        System.out.println(root.val);
        if (root.right != null) {
            printTree(root.right);
        }
    }

    private void insertNode(TreeNode root, TreeNode elem) {
        if (root.val > elem.val) {
            if (root.left == null) {
                root.left = elem;
            } else {
                insertNode(root.left, elem);
            }
        } else {
            if (root.right == null) {
                root.right = elem;
            } else {
                insertNode(root.right, elem);
            }
        }
    }

    private TreeNode createNode(int value) {
        return new TreeNode(value);
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

