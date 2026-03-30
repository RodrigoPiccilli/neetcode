class Solution {
    public int evalRPN(String[] tokens) {

        // Add numbers onto stack until operator comes up
        // Pop the last two, apply operator, add result
        // Continue until end

        Stack<Integer> stack = new Stack();

        for(String s : tokens) {

            if(s.equals("+")) {

                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push((num1 + num2));

            } else if(s.equals("-")) {

                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push((num1 - num2));

            } else if(s.equals("*")) {

                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push((num1 * num2));

            } else if(s.equals("/")) {

                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push((num1 / num2));

            } else {
                stack.push(Integer.parseInt(s));
            }

        }

        return stack.pop();
        
    }
}
