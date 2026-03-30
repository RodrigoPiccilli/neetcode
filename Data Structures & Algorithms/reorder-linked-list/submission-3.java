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

        // First, we must find the midpoint of the original list.
        
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;

        slow.next = null;

        // Reverse Second Half

        ListNode prev = null;

        while(second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;        
        }

        // Merge Lists

        ListNode first = head;
        second = prev;

        while(second != null) {

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;

        }

    }
}
