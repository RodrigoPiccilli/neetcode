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

    private void addNode(Node node) {

        Node temp = tail.prev;
        node.next = tail;
        tail.prev = node;
        temp.next = node;
        node.prev = temp;

    }

    private void removeNode(Node node) {

        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

    }

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        head = new Node(-1, -1, null, null);
        tail = new Node(-1, -1, null, null);

        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {
        
        if(!cache.containsKey(key)) return -1;

        Node get = cache.get(key);

        removeNode(get);
        addNode(get);

        return get.val;


    }
    
    public void put(int key, int value) {

        if(cache.containsKey(key)) { // Updating
            removeNode(cache.get(key));
        }

        Node newNode = new Node(key, value, null, null);

        cache.put(key, newNode);

        addNode(cache.get(key));

        if(capacity < cache.size()) {

            Node remove = head.next;

            removeNode(remove);

            cache.remove(remove.key);

        }
        
    }
}
