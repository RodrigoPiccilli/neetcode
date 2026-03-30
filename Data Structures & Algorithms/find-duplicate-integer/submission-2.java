class Solution {

    class Node {

        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }

         public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }

    public int findDuplicate(int[] nums) {

        Node head = new Node(0);
        Node tail = head;

        for(int n : nums) {
            int result = addToList(n, head, tail);
            if(result != -1) return result;
        }

        return -1;

        
    }

    private int addToList(int val, Node head, Node tail) {

        // Iterate through linked list
        // If value is not found, add it to the list.
        // If value is found, return the value.

        Node traverse = head;

        while(traverse != null) {
            System.out.print(val + " " + traverse.val + "  ");
            if(val == traverse.val) return val;
            traverse = traverse.next;

        }

        Node temp = head.next;
        head.next = new Node(val, temp);
        
        return -1;

    }
}
