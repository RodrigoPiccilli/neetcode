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
    public ListNode reverseList(ListNode head) {
        
        ListNode traverse = head;
        ListNode previous = null;

        while(traverse != null) {

            if(traverse.next == null) head = traverse;

            ListNode temp = traverse.next;

            if(temp != null ) head = temp;

            traverse.next = previous;

            previous = traverse;
            
            traverse = temp;

            
        }

            return head;

    }
}
