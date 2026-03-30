class Solution {
    public boolean isValid(String s) {

        // Add to stack opposite symbol
        Stack<Character> stack = new Stack();

        for(char c : s.toCharArray()) {

            if((c == ']' || c == ')' || c == '}') && stack.size() == 0) return false;

            if(c == '[') {
                stack.push(']');
            } else if(c == '(') {
                stack.push(')');
            } else if(c == '{') {
                stack.push('}');
            } else {
                char top = stack.pop();
                if(top != c) return false;
            }
        }

        return stack.size() == 0;
        
    }
}
