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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // if fast == null, slow = slow.next

        // if fast != null, slow.next = slow.next.next

        // [1, s2, 3, f4]

        // [ s1, 2]

        ListNode slow = head;
        ListNode fast = head;

        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if(fast == null) {
            return head.next;
        } 
        
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;

    }
}
