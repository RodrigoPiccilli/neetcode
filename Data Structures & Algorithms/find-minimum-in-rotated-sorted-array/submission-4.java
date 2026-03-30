class Solution {
    public int findMin(int[] nums) {
        
        int l = 0;
        int r = nums.length - 1;

        while(l < r) {

            int mid = l + (r - l) / 2;

            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }


        }

        // Return min element, or the pivot of the rotated array
        return nums[l];
    }
}
