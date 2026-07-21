class Solution {
    public int trap(int[] height) {

        int leftMax = 0;
        int rightMax = 0;

        int l = 0;
        int r = height.length - 1;

        int res = 0;
        
        while(l < r) {

            leftMax = Math.max(height[l], leftMax);
            rightMax = Math.max(height[r], rightMax);

            if(leftMax <= rightMax) {
                res += leftMax - height[l];
                l++;

            } else if(leftMax > rightMax) {
                res += rightMax - height[r];
                r--;
            }

        }

        return res;
        
        
    }
}
