class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        if(s.length() < 2) return false;
        
        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(') stack.push(')');
            if(s.charAt(i) == '{') stack.push('}');
            if(s.charAt(i) == '[') stack.push(']');

            if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {

                if(stack.isEmpty() || s.charAt(i) != stack.pop()) return false;

            }

        }

        if(!stack.isEmpty()) return false;

        return true;




    }
}
