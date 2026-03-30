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
        ListNode c = dummy;

        int carry = 0;
        int sum = 0;

        while(l1 != null || l2 != null || carry != 0) {

            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;

            int total = val1 + val2 + carry;

            ListNode newNode = new ListNode(total % 10);

            carry = total / 10;

            c.next = newNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            c = c.next;

        }

        return dummy.next;

    }
}
