class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int top = stack.pop();

                int height = heights[top];

                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                max = Math.max(max, (height * width));
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();

            int height = heights[top];

            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;

            max = Math.max(max, (height * width));
        }

        return max;
    }
}
