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

            int l1Val = (l1 == null) ? 0 : l1.val;
            int l2Val = (l2 == null) ? 0 : l2.val;

            sum = l1Val + l2Val;

            int val = (sum + carry) % 10;
            carry = (sum + carry) / 10;

            traverse.next = new ListNode(val);

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            

            traverse = traverse.next;

        }

        return dummy.next;

    }
}
