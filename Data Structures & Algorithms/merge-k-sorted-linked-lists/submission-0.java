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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode newList = null;

        for(ListNode node : lists) {
            ListNode merge = mergeLists(node, newList);
            newList = merge;
        }

        return newList;

    }

    private ListNode mergeLists(ListNode list1, ListNode list2) {


        ListNode dummy = new ListNode(-1);
        ListNode traverse = dummy;

        while(list1 != null && list2 != null) {

            if(list1.val <= list2.val) {
                ListNode temp = list1;
                traverse.next =  temp;
                list1 = list1.next;
            } else {
                ListNode temp = list2;
                traverse.next = temp;
                list2 = list2.next;
            }

            traverse = traverse.next;
        }

        traverse.next = (list1 == null) ? list2 : list1;

        return dummy.next;




    }
}
