class Solution {
    public boolean isValid(String s) {
        if(s.length() < 2) return false;

        // { () }
        // {} {}

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars) {

            if(c == '(') {
                stack.push(')');
            }

            if(c == '{') {
                stack.push('}');
            }

            if(c == '[') {
                stack.push(']');
            }

            if(c == ')' || c == '}' || c == ']') {
                if(stack.isEmpty()) return false;
                char pop = stack.pop();
                if(pop != c) return false;
            }

        }

        return stack.isEmpty();
    }
}
