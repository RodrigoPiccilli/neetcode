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
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

       
        do {
            
            if(fast.next == null || fast.next.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;

        } while(fast == null || slow.val != fast.val );

        return true;


        
    }
}
