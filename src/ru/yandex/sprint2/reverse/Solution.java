package ru.yandex.sprint2.reverse;

// E. Всё наоборот - разворачивание двусвязного списка
// https://contest.yandex.ru/contest/22779/problems/E/
// <template>
class Node<V> {
    public V value;
    public Node<V> next;
    public Node<V> prev;

    public Node(V value, Node<V> next, Node<V> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
// <template>

public class Solution {
    public static Node<String> solution(Node<String> head) {
        // Your code
        // ヽ(´▽`)/
        Node current = head;
        Node prev = null;

        while (current != null) {
            swap(current);
            prev = current;
            current = current.prev;
        }
        if (prev != null) {
            head = prev;
        }
        return head;
    }

    private static void swap(Node node) {
        Node prevTmp = node.prev;
        node.prev = node.next;
        node.next = prevTmp;
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null, null);
        Node<String> node2 = new Node<>("node2", node3, null);
        Node<String> node1 = new Node<>("node1", node2, null);
        Node<String> node0 = new Node<>("node0", node1, null);
        node1.prev = node0;
        node2.prev = node1;
        node3.prev = node2;
        Node<String> newNode = solution(node0);
        /* result is :*/
        assert newNode == node3;
        assert node3.next == node2;
        assert node2.next == node1;
        assert node2.prev == node3;
        assert node1.next == node0;
        assert node1.prev == node2;
        assert node0.prev == node1;
    }

    public static void main(String[] args) {
        test();
    }

}