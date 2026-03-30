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
        
        int sum = 0;
        int carry = 0;

        ListNode dummy = new ListNode();
        ListNode traverse = dummy;

        while(l1 != null || l2 != null || carry != 0) {

            if(l1 != null && l2 != null) {
                sum = l1.val + l2.val;
            } else if(l1 == null && l2 == null) {
                sum = 0;
            } else if(l2 == null) {
                sum = l1.val;
            } else {
                sum = l2.val;
            }

            int val = (sum + carry) % 10;
            carry = (sum + carry) / 10;

            traverse.next = new ListNode(val);

            if(l1 != null) l1 = l1.next;

            if(l2 != null) l2 = l2.next;

            traverse = traverse.next;

        }

        return dummy.next;

    }
}
