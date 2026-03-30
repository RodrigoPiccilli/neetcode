/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Map<Node, Node> map = new HashMap<>();

        Node current = head;

        while(current != null) {
            Node newNode = new Node(current.val);
            map.put(current, newNode);
            current = current.next;
        }

        Node dummy = new Node(0);
        Node traverse = dummy;

        while(head != null) {
            // Go through the original list.
            // Retrieve the new node, and use key to find references in the map.
            traverse.next = map.get(head);
            traverse.next.next = map.get(head.next);
            traverse.next.random = map.get(head.random);
            traverse = traverse.next;
            head = head.next;
        }

        return dummy.next;

    }
}
