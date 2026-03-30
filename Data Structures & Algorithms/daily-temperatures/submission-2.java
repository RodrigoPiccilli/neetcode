class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for(int i = 1; i < temperatures.length; i++) {

            int popIndex = stack.peek();

            while(temperatures[popIndex] < temperatures[i]) {
                result[popIndex] = i - popIndex;
                stack.pop();
                if(!stack.isEmpty()) {
                    popIndex = stack.peek();
                } else {
                    break;
                }
            }

            stack.push(i);

        }

        return result;
        
    }
}
