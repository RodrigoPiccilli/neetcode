class Solution {
    public int maxArea(int[] heights) {
        
        int l = 0;
        int r = heights.length - 1;

        // Amount of Water = MAX(left bar, right bar)  * distance between left bar and right bar
        // LEFT BAR -> If bar to the right is not taller, we can stay put.
        // RIGHT BAR -> If bar to the left is not taller, we can stay put.
        // LEFT BAR + RIGHT BAR = TALLEST -> Move both inward in case of taller ones

        int max = 0;

        while(l < r) {

            int leftBar = heights[l];
            int rightBar = heights[r];

            int current = Math.min(leftBar, rightBar) * (r - l);

            max = Math.max(current, max);
            
            if(leftBar < rightBar) {
                l++;
            } else if(rightBar < leftBar) {
                r--;
            } else {
                l++;
                r--;
            }

        }

        return max;

    }
}
