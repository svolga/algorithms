package java.leetcode.linkedlist.removeduplicates;

// 83. Remove Duplicates from Sorted List
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {

        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(1, node1);

   /*     ListNode node1 = new ListNode(1);
        ListNode head = new ListNode(1, node1);*/

        print(head);
        ListNode result = deleteDuplicates(head);
        print(result);

    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }

        }
        return head;
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
