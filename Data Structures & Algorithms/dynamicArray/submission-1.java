class DynamicArray {

    private int array[];
    private int size;
    private int capacity;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        size = 0;
        array = new int[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if(size == capacity) resize();

        size++;

        array[size - 1] = n;
    }

    public int popback() {
        int pop = array[size-  1];

        array[size - 1] = 0;

        size--;

        return pop;
    }

    private void resize() {

        capacity *= 2;

        array = Arrays.copyOf(array, capacity);

    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
