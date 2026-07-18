class Solution {
    public int maxArea(int[] heights) {
        
        int l = 0;
        int r = heights.length - 1;

        int max = 0;

        while(l < r) {

            int w = r - l;
            int h = Math.min(heights[r], heights[l]);

            max = Math.max(max, w * h);

            if(heights[r] < heights[l]) {
                r--;
            } else {
                l++;
            }
            
        }

        return max;

    }
}
