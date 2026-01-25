package java.yandex.sprint5.balancedtree;

// B. Сбалансированное дерево
// https://contest.yandex.ru/contest/24809/problems/B/
public class Solution {

/*
    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        test();
    }
*/

    public static boolean treeSolution(Node head) {
        // Your code
        // “ヽ(´▽｀)ノ”
        int height = getHeight(head);
        return height != -1;
    }


    private static int getHeight(Node head) {
        if (head == null) {
            return 0;
        }

        int left = getHeight(head.left);
        int right = getHeight(head.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
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
    }
    // <template>

    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(10);
        Node node5 = new Node(2);
        node5.left = node3;
        node5.right = node4;
        assert treeSolution(node5);
    }
}