class Solution {
    public int maxArea(int[] heights) {
        
        // Return Max Amount of Water a Container can Store

        // Basically, we want the tallest ones that are the farthest apart from each other.

        // Distance Between Pointers * Min(Pointer 1, Pointer 2)

        int start = 0;

        int end = heights.length - 1;

        int champion = 0;

        while(start <= end) {

            int distance = end - start;

            int height = Math.min(heights[start], heights[end]);

            champion = Math.max(champion, (distance * height));

            if(heights[start] > heights[end]) {
                end--;
            } else if(heights[start] < heights[end]) {
                start++;
            } else {
                start++;
                end--;
            }

        }

        return champion;

    }
}
