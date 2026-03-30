class MinStack {

    Stack<Integer> stack;
    Stack<Integer> mins;

    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if(mins.isEmpty() || mins.peek() >= val) mins.push(val);
    }
    
    public void pop() {
        int removed = stack.pop();

        if(removed == mins.peek()) mins.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }

}
