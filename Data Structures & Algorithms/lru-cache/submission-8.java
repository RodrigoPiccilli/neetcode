class LRUCache {

    private class Node {

        private int key;
        private int val;
        private Node next;
        private Node prev;

        public Node(int key, int val, Node next, Node prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1, null, null);
        tail = new Node(-1, -1, null, null);

        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node node) {

        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;

    }

    private void removeNode(Node node) {

        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
      
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);

        removeNode(node);
        addNode(node);

        return node.val;

    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)) {

            Node node = map.get(key);

            removeNode(node);

            node.val = value;

            addNode(node);

            map.put(key, node);

        } else {

            Node newNode = new Node(key, value, null, null);

            if(capacity == 0) {

                map.remove(head.next.key);

                removeNode(head.next);
                
                capacity++;

            }

            map.put(key, newNode);
            addNode(newNode);
            capacity--;

        }
        
    }
}
