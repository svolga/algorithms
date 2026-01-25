package java.yandex.sprint5.tree.maxheight;

// F. Максимальная глубина
// https://contest.yandex.ru/contest/24809/problems/F/
public class Solution {

/*
    public static void main(String[] args) {
        test();
    }
*/

    public static int treeSolution(Node head) {
        // Your code
        // “ヽ(´▽｀)ノ”
        if (head == null){
            return 0;
        }

        int left = treeSolution(head.left);
        int right  = treeSolution(head.right);

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

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    // <template>

    private static void test() {
/*
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        assert treeSolution(node5) == 3;
*/

        Node node5 = new Node(5);
        Node node12 = new Node(12, node5, null);
        Node node8 = new Node(8);
        Node node1 = new Node(1, node8, node12);
        Node node4 = new Node(4);
        Node node3 = new Node(3, node1, node4);

        assert treeSolution(node3) == 4;

    }
}
