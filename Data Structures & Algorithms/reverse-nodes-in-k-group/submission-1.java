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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1, head);
        ListNode groupPrev = dummy;
        
        while(true) {
        
            ListNode kth = findKth(groupPrev, k);

            if(kth == null) break;

            ListNode groupNext = kth.next;

            ListNode current = groupPrev.next;
            ListNode prev = null;

            while(current != groupNext) {

                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;

            }

            ListNode temp = groupPrev;
            groupPrev = groupPrev.next;
            groupPrev.next = groupNext;
            temp.next = kth;


        }

        return dummy.next;



    }

    private ListNode findKth(ListNode head, int k) {

        while(head != null && k > 0) {
            head = head.next;
            k--;
        }

        return head;

    }
}
