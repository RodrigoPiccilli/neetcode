class LRUCache {

    private class Node {

        private int key;
        private int val;
        private Node next;
        private Node prev;

        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node(-1, -1, null, null);
        tail = new Node(101, -1, null, null);

        head.next = tail;
        tail.prev = head;

    }

    public void removeNode(Node node) {

        Node next = node.next;
        Node prev = node.prev;

        node.prev.next = next;
        node.next.prev = prev;

    }

    public void addNode(Node node) {

        Node temp = tail.prev;
        
        temp.next = node;
        
        tail.prev = node;
        
        node.next = tail;
        node.prev = temp;

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

        addNode(newNode);


        if(cache.size() > capacity) {

            Node remove = head.next;

            removeNode(remove);

            cache.remove(remove.key);

        }
        
    }
}
