package java.yandex.sprint5.tree.numberpath;

// H. Числовые пути
// https://contest.yandex.ru/contest/24809/problems/H/
public class Solution {

    static Integer sum = 0;

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
/*
        Node node2 = new Node(2);

        Node node2r = new Node(2);
        Node node1 = new Node(1);
        Node node3 = new Node(3, node2r, node1);

        Node root = new Node(1, node2, node3);
*/
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node root = new Node(1, node3, node5);

        int sum = treeSolution(root);
        System.out.println("common sum = " + sum);
    }

    public static int treeSolution(Node head) {
        // Your code
        // “ヽ(´▽｀)ノ”
        dfs(head, String.valueOf(head.value));
        return sum;
    }

    private static void dfs(Node head, String parent) {
        if (head == null) {
            return;
        }

        if (head.left != null) {
            dfs(head.left, parent + String.valueOf(head.left.value));
        }
        if (head.right != null) {
            dfs(head.right, parent + String.valueOf(head.right.value));
        }

        if (head.left == null && head.right == null) {
            sum += Integer.valueOf(parent);
        }
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
        Node node1 = new Node(2, null, null);
        Node node2 = new Node(1, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(2, null, null);
        Node node5 = new Node(1, node4, node3);
        assert treeSolution(node5) == 275;
    }
}
