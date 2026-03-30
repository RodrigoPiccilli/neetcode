class Solution {
    public boolean isValid(String s) {

        if(s.length() < 2) return false; 

        Stack<Character> stack = new Stack<>();

        char[] characters = s.toCharArray();

        for(char c : characters) {

            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);

            } else {

                if(stack.size() == 0 || c == ')' && stack.pop() != '(' || 
                c == '}' && stack.pop() != '{' ||
                c == ']' && stack.pop() != '[' ) return false;

            }
            
        }

        return stack.size() == 0;
    }
}
