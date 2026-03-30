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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        // Dummy Node
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode current = dummy;

        while(list1 != null || list2 != null) {

            ListNode val1 = list1;
            ListNode val2 = list2;

            if(val1 == null || val2 == null) {
                current.next = val1 == null ? list2 : list1;
                break;
            } else if(val1.val < val2.val) {
                list1 = list1.next;
                current.next = val1;
            } else {
                list2 = list2.next;
                current.next = val2;
            }


            current = current.next;

        }

        return dummy.next;


    }
}