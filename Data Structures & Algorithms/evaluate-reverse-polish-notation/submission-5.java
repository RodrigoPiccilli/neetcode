class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        int num2 = 0;
        int num1 = 0;

        for(String s : tokens) {

            switch(s) {
                case "+":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                case "-":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 - num2);
                    break;
                case "*":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 * num2);
                    break;
                case "/":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 / num2);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
            
        }

        return stack.pop();
        
    }
}
