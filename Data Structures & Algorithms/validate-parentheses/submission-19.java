class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {

            if(c == '(') {
                stack.push(')');
            } else if(c == '{') {
                stack.push('}');
            } else if(c == '[') {
                stack.push(']');
            } else {
                if(stack.size() == 0) return false;
                char top = stack.peek();
                if(top != c) return false;
                stack.pop();
            }
        }

        return stack.size() == 0;

    }
}
