class Solution {
    public boolean isValid(String s) {
        
        if(s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) =='(') {
                stack.push(')');
            }

            if(s.charAt(i) =='{') {
                stack.push('}');
            }

            if(s.charAt(i) =='[') {
                stack.push(']');
            }

            if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if(stack.isEmpty() || stack.pop() != s.charAt(i)) return false;
            }

        }

        return stack.isEmpty();
    }
}
