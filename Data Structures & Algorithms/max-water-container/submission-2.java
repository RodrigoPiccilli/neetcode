class Solution {
    public int maxArea(int[] heights) {
        
        int max = 0;
        int left = 0;
        int right = heights.length - 1;

        while(left <= right) {

            int height = Math.min(heights[left], heights[right]);

            int current = (right - left) * height;

            max = Math.max(current, max);

            if(heights[left] > heights[right]) {
                right--;
            } else if(heights[left] < heights[right]) {
                left++;
            } else {
                left++;
                right--;
            }

        }

        return max;

    }
}
