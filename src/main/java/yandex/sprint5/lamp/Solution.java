package java.yandex.sprint5.lamp;

// A. Лампочки
// https://contest.yandex.ru/contest/24809/problems/A/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
//        test();
    }

    private void run(String[] args) {
        test2();
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
        Node node4 = new Node(2);
        node4.left = node3;
        assert treeSolution(node4) == 3 : "Неверный результат, ожидалось " + 3 + " , в реальности: " + node4;
        int h = 0;
    }

    public static int treeSolution(Node head) {
        // Your code
        // “ヽ(´▽｀)ノ”
        if (head == null) {
            return 0;
        }

        int max = head.value;

        int leftMax = treeSolution(head.left);
        int rightMax = treeSolution(head.right);

        if (leftMax > max) {
            max = leftMax;
        }

        if (rightMax > max) {
            max = rightMax;
        }

        return max;
    }


    private void test2() {
        int[] items = {-3, 1, -5, 42, 2, -6, 8};
//        int[] items = {1, 3, 8, 10, 14, 15, 3, 5, 2, 6, 0, 1};


        Node root = createTreeElement(0);
        for (int i = 0; i < items.length; i++) {
            Node node = createTreeElement(items[i]);
            insertIntoTree(root, node);
        }

        printTree(root);
        int x = treeSolution(root);
        System.out.println(x);
    }

    private int getMax(Node root) {
        return 0;
    }

    private Node createTreeElement(int value) {
        Node node = new Node(value);
        return node;
    }

    private void insertIntoTree(Node root, Node elem) {
        if (elem.value < root.value) {
            if (root.left == null) {
                root.left = elem;
            } else {
                insertIntoTree(root.left, elem);
            }
        } else {
            if (root.right == null) {
                root.right = elem;
            } else {
                insertIntoTree(root.right, elem);
            }
        }
    }

    Node insertNode(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.value) {
            root.left = insertNode(root.left, key);
        } else if (key >= root.value) {
            root.right = insertNode(root.right, key);
        }

        return root;
    }


    private void printTree(Node node) {
        if (node.left != null) {
            printTree(node.left);
        }
        System.out.println("Value = " + node.value);
        if (node.right != null) {
            printTree(node.right);
        }
    }

    private Node findNode(Node root, int value) {

        if (root == null || value == root.value){
            return root;
        }

        if (value < root.value) {
            return findNode(root.left, value);
        }
        else if (value > root.value) {
            return findNode(root.right, value);
        }

        return null;
    }

}
