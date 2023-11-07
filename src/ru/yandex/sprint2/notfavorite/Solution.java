package ru.yandex.sprint2.notfavorite;

// C. Нелюбимое дело
// https://contest.yandex.ru/contest/22779/problems/C/

// <template>
class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}
// <template>

public class Solution {
    public static Node<String> solution(Node<String> head, int idx) {
        // Your code
        // ヽ(´▽`)/
        if (idx == 0){
            head = head.next;
            return head;
        }

        Node node = findNodeByIndex(head, idx);
        Node nodePrev = idx == 0 ? null : findNodeByIndex(head, idx - 1);
        if (node.next == null){
            nodePrev.next = null;
            return head;
        }

        nodePrev.next = node.next;
        return head;
    }

    private static Node findNodeByIndex(Node node, int idx) {

        while (idx > 0) {
            node = node.next;
            idx--;
        }
        return node;
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);

        Node<String> newHead = solution(node0, 1);
        assert newHead == node0;
        assert newHead.next == node2;
        assert newHead.next.next == node3;
        assert newHead.next.next.next == null;
        // result is : node0 -> node2 -> node3
    }

    //
    public static void main(String[] args) {
        test();
    }

}
