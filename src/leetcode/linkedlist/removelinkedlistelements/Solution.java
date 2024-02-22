package leetcode.linkedlist.removelinkedlistelements;

// 203. Remove Linked List Elements
// https://leetcode.com/problems/remove-linked-list-elements/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {

        int[] values = {6, 6, 1, 2, 6, 3, 4, 5, 6};
        int val = 6;

        ListNode head = arrayToLinkedList(values);
        print(head);
        ListNode fixedNode = removeElements(head, val);
        System.out.println("---------------------------------");
        print(fixedNode);
    }


    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode temp = new ListNode(0, head);
        ListNode cur = temp;
        while (cur.next != null) {
            if (val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return temp.next;
    }


/*
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        if (head.val == val){
            head = head.next;
        }

        return head;
    }
*/


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
