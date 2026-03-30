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

        // Reverse and Merge after getting to the middle of the list.

        // Find middle of list
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Now we know that fast points to the middle of the list.
        // We can now reverse the second half of the list.
        ListNode prev = null;
        ListNode current = slow.next;

        slow.next = null;

        while(current != null) {

            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }

        // prev now refers to the head of the reversed list.
        // Now we can merge them.

        ListNode dummy = new ListNode();
        ListNode traverse = dummy;
        current = head;
        while(current != null) {

            traverse.next = current;
            traverse = traverse.next;
            current = current.next;

            if(prev != null) {
                traverse.next = prev;
                traverse = traverse.next; 
                prev = prev.next;
            }
            
        }

        head = dummy.next;



    }
}
