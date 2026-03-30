/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {

        // Reverse and Merge

        // Step 1: Find Midpoint

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;

        // Split lists
        slow.next = null;

        // Step 2: Reverse Second List

        ListNode prev = null;

        while(second != null) {

            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;

        }

        second = prev;

        // Step 3: Merge Lists

        ListNode traverse = head;

        while(traverse != null && second != null) {

            ListNode c1 = traverse;
            ListNode n1 = traverse.next;
            ListNode c2 = second;
            ListNode n2 = second.next;

            c1.next = c2;
            c2.next = n1;

            traverse = n1;
            second = n2;

        }

    }
}
