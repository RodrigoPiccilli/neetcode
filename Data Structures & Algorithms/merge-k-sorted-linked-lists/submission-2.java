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

        if(lists.length == 0 || lists == null) return null;


        while(lists.length > 1) {

            ArrayList<ListNode> mergedLists = new ArrayList<>();

            for(int i = 0; i < lists.length; i += 2) {

                ListNode l1 = lists[i];
                ListNode l2 = (i + 1 >= lists.length) ? null : lists[i + 1];

                ListNode newList = merge(l1, l2);

                mergedLists.add(newList);

            }

            lists = mergedLists.toArray(new ListNode[0]);
        }

        return lists[0];

    }

    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode traverse = dummy;

        while(l1 != null && l2 != null) {

            int val1 = l1.val;
            int val2 = l2.val;

            if(val1 <= val2) {
                traverse.next = l1;
                l1 = l1.next;
            } else {
                traverse.next = l2;
                l2 = l2.next;
            }

            traverse = traverse.next;

        }

        traverse.next = (l1 == null) ? l2 : l1;

        return dummy.next;

    }
}
