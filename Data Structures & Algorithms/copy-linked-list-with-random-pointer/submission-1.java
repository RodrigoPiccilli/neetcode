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

    // Check variable names
    // Check ;
    public Node copyRandomList(Node head) {
        
        Map<Node, Node> nodes = new HashMap<>();

        Node current = head;

        while(current != null) {

            Node newNode = new Node(current.val);

            nodes.put(current, newNode);

            current = current.next;

        }

        Node dummy = new Node(0);
        Node traverse = dummy;

        current = head;

        while(current != null) {

            Node next = nodes.get(current.next);
            Node random = nodes.get(current.random);

            traverse.next = nodes.get(current);
            traverse.next.next = next;
            traverse.next.random =  random;

            current = current.next;
            traverse = traverse.next;

        }

        return dummy.next;

    }
}
