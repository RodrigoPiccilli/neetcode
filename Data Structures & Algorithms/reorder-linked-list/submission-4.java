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

        // 1) Find the midpoint of the list

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;

        slow.next = null;

        // 2) Reverse Second List

        ListNode prev = null;
        
        while(second != null) {

            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;

        }

        second = prev; // Head of reversed list

        // 3) Merge

        ListNode mergedList = head;

        while(second != null) {

            ListNode next = head.next;

            head.next = second;

            second = second.next;

            head.next.next = next;

            head = next;

        }

        head = mergedList;


    }
}
