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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode traverse = dummy;

        int carry = 0;

        while(l1 != null && l2 != null) {
            int val = l1.val + l2.val;
            val += carry;
            carry = val / 10;
            traverse.next = new ListNode(val % 10);
            l1 = l1.next;
            l2 = l2.next;
            traverse = traverse.next;
        }

        ListNode remaining = l1 == null ? l2 : l1;

        while(remaining != null) {
            int val = remaining.val;
            val += carry;
            carry = val / 10;
            traverse.next = new ListNode(val % 10);
            remaining = remaining.next;
            traverse = traverse.next;
        }
        
        if(carry != 0) {
            traverse.next = new ListNode(carry);
        }

        return dummy.next;
        
    }
}
