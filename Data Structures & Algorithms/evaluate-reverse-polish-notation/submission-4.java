class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String s : tokens) {

            switch(s) {
                case "+":
                    int add2 = stack.pop();
                    int add1 = stack.pop();
                    stack.push(add1 + add2);
                    break;
                case "-":
                    int sub2 = stack.pop();
                    int sub1 = stack.pop();
                    stack.push(sub1 - sub2);
                    break;
                case "*":
                    int mul2 = stack.pop();
                    int mul1 = stack.pop();
                    stack.push(mul1 * mul2);
                    break;
                case "/":
                    int div2 = stack.pop();
                    int div1 = stack.pop();
                    stack.push(div1 / div2);
                    break;
                default:
                    int num = Integer.parseInt(s);
                    stack.push(num);
            }

        }

        return stack.pop();
        
    }
}
