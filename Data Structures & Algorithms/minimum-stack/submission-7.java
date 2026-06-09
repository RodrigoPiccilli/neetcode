class MinStack {

    private Stack<Integer> min;
    private Stack<Integer> main;

    public MinStack() {
        main = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {

        main.push(val);
        
        if(min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }

    }
    
    public void pop() {

        if(main.pop().equals(min.peek())) {
            min.pop();
        }
        
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
