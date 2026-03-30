class Solution {
    public int findMin(int[] nums) {
 
        // 1. Find Partition
        // 2. Return Element Right After Partition, should be the min.

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {

            if(nums[left] < nums[right]) break;

            int mid = (left + right) / 2;

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return nums[left];
        
    }
}
