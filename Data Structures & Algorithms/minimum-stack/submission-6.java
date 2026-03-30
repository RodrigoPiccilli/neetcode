class MinStack {

    private Stack<Integer> min;
    private Stack<Integer> stack;

    public MinStack() {
        min = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(min.size() == 0 || min.peek() >= val) min.push(val);
        stack.push(val);
    }
    
    public void pop() {
        int pop = stack.pop();
        if(min.peek() == pop) min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
