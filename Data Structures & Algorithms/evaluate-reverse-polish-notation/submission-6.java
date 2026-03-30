class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack();
        
        for(String token : tokens) {

            int val1, val2, result;

            if(token.equals("+")) {

                val2 = stack.pop();
                val1 = stack.pop();
                result = val1 + val2;
                stack.push(result);

            } else if(token.equals("-")) {

                val2 = stack.pop();
                val1 = stack.pop();
                result = val1 - val2;
                stack.push(result);

            } else if(token.equals("*")) {

                val2 = stack.pop();
                val1 = stack.pop();
                result = val1 * val2;
                stack.push(result);
                
            } else if(token.equals("/")) {

                val2 = stack.pop();
                val1 = stack.pop();
                result = val1 / val2;
                stack.push(result);
                
            } else {
                stack.push(Integer.parseInt(token));
            }


        }

        return stack.pop();


    }
}
