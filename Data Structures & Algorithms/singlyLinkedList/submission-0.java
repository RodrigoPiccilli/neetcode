class LinkedList {

    private class LinkedNode {

        private int val;
        private LinkedNode next;

        public LinkedNode(int val, LinkedNode next) {

            this.val = val;
            this.next = next;

        }


    }

    private LinkedNode head;

    private LinkedNode tail;

    private int size;


    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {

        if(index > size - 1) return -1;
        
        int count = 0;

        LinkedNode traversal = head;

        while(count != index) {

            traversal = traversal.next;
            count++;

        }

        return traversal.val;

    }

    public void insertHead(int val) {
        
        if(head == null) {

            head = new LinkedNode(val , null);
            tail = head;

        } else {

            LinkedNode newHead = new LinkedNode(val, head);
            head = newHead;

        }

        size++;



    }

    public void insertTail(int val) {

        if(tail == null) {

            tail = new LinkedNode(val, null);
            head = tail;

        } else {

            LinkedNode newTail = new LinkedNode(val, null);
            tail.next = newTail;
            tail = newTail;

        }

        size++;


    }

    public boolean remove(int index) {
        
        if(index > size - 1) return false;

        if (head == null) return false;

        if(index == 0) {

            head = head.next;

            if (head == null) {
                tail = null;
            }

            size--;

            return true;

        }

        LinkedNode traversal = head;

        for (int i = 0; i < index - 1; i++) {
        if (traversal == null || traversal.next == null) {
            throw new IllegalStateException("List structure is corrupted or index is out of bounds.");
        }
        traversal = traversal.next;
    }

        if(index == size - 1) {

            traversal.next = null;

            tail = traversal;

        } else {

            traversal.next = traversal.next.next;

        }

        size--;


        

        return true;


    }

    public ArrayList<Integer> getValues() {

        ArrayList<Integer> values = new ArrayList<Integer>();

        int count = 0;

        LinkedNode traversal = head;

        for(int i = 0; i < size; i++) {

            values.add(traversal.val);

            traversal = traversal.next;

            count++;

        }

        return values;


    }
}
