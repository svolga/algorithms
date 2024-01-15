package ru.yandex.sprint5.tree.maxpath;

import java.util.LinkedList;
import java.util.Queue;

// G. Максимальный путь в дереве
// https://contest.yandex.ru/contest/24809/problems/G/
public class Solution {

    private static int maxPathSum;

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {

    }

    public static int treeSolution(Node head) {
        // Your code
        // “ヽ(´▽｀)ノ”
        maxPathSum = Integer.MIN_VALUE;
        pathSum(head);
        return maxPathSum;
    }

    private static int pathSum(Node root){
        if (root == null){
            return 0;
        }

        int leftSum = Math.max(0, pathSum(root.left));
        int rightSum = Math.max(0, pathSum(root.right));

        maxPathSum = Math.max(maxPathSum, leftSum + rightSum + root.value);
        return Math.max(leftSum, rightSum) + root.value;
    }

    // <template>
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    // <template>


    private static void test() {
        Node node1 = new Node(5, null, null);
        Node node2 = new Node(1, null, null);
        Node node3 = new Node(-3, node2, node1);
        Node node4 = new Node(2, null, null);
        Node node5 = new Node(2, node4, node3);
        assert treeSolution(node5) == 6;

        printLevelOrder(node5);
    }

    // BFS - обход дерева в ширину
    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.value + " ");

            /*add left child to the queue */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*add right right child to the queue */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

}