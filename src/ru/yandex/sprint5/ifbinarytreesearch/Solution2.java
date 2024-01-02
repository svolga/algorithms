package ru.yandex.sprint5.ifbinarytreesearch;


import java.util.ArrayList;
import java.util.List;

// E. Дерево поиска
// https://contest.yandex.ru/contest/24809/problems/E/
public class Solution2 {

    public static void main(String[] args) {
        new Solution2().run(args);
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

        boolean isBinarySearch = true;
        isBinarySearch(root, isBinarySearch);

        System.out.println("isBinarySearch = " + isBinarySearch);
    }


    void isBinarySearch(TreeNode root, Boolean isBinary) {
        if (root == null || !isBinary) {
            return;
        }
        if (root.left != null && root.right!=null) {
            if (root.left.val < root.right.val){
                isBinary = true;
            }
            else{
                isBinary = false;
            }
        }
        isBinarySearch(root.left, isBinary);
        isBinarySearch(root.right, isBinary);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
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

