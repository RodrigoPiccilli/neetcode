class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] solution = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        
        // Idea: Use Stack.size() as a counting mechanism.

        for(int i = 0; i < temperatures.length - 1; i++) {

           stack.push(i);

           while(!stack.isEmpty() && temperatures[i + 1] > temperatures[stack.peek()]) {
                int index = stack.pop();
                solution[index] = i + 1 - index;
           }

        } 

        return solution;

    }
}
