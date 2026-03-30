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

        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();

        while(l1 != null) {
            n1.append(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            n2.append(l2.val);
            l2 = l2.next;
        }

        int sum = Integer.parseInt(n1.reverse().toString()) + Integer.parseInt(n2.reverse().toString());
    
        int length = (sum + "").length();

        ListNode dummy = new ListNode(0);

        ListNode traverse = dummy;

        for(int i = 0; i < length; i++) {
            traverse.next = new ListNode(sum % 10);
            sum /= 10;
            traverse = traverse.next;
        }
       
        return dummy.next;

        
        

        
    }
}
