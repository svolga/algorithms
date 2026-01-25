package java.leetcode.linkedlist.middlelinkedlist;


// 876. Middle of the Linked List
// https://leetcode.com/problems/middle-of-the-linked-list/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {

        int[] values = {1, 2, 3, 4, 5, 6};
//        int[] values = {1};

        ListNode head = arrayToLinkedList(values);
        print(head);
        ListNode secondNode = middleNode(head);
//        ListNode fixedNode = removeElements(head, val);
        System.out.println("---------------------------------");
        print(secondNode);
    }

    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            count++;
        }

        node = head;
        for (int i = 0; i < count / 2 + count % 2; i++) {
            node = node.next;
        }

        return node;
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private ListNode arrayToLinkedList(int[] values) {

        ListNode node = null;
        ListNode next = null;
        for (int i = values.length - 1; i >= 0; i--) {
            node = new ListNode(values[i], next);
            next = node;
        }

        return node;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
