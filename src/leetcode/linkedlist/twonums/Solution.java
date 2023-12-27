package leetcode.linkedlist.twonums;

// 2. Add Two Numbers
// https://leetcode.com/problems/add-two-numbers/submissions/1129513513/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
/*
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
 */
        ListNode node1 = getNodeFromArray(new int[]{2, 4, 3});
        ListNode node2 = getNodeFromArray(new int[]{5, 6, 4});
/*
        ListNode node1 = getNodeFromArray(new int[]{1, 9, 9, 9, 9, 9, 9, 9, 9, 9});
        ListNode node2 = getNodeFromArray(new int[]{9});
*/

        ListNode node3 = addTwoNumbers(node1, node2);
        System.out.println(node1);
        System.out.println(node2);
        System.out.println(node3);
    }

    private ListNode getNodeFromArray(int[] array) {
        ListNode node = null;
        ListNode next = null;
        for (int i = array.length - 1; i >= 0; i--) {
            node = new ListNode(array[i], next);
            next = node;
        }
        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;

        ListNode temp = null;
        // Остаток
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(sum % 10);

            carry = sum / 10;
            if (temp == null) {
                temp = head = node;
            }
            else {
                temp.next = node;
                temp = temp.next;
            }
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return head;
    }


    public class ListNode {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


}
