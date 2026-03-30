class Solution {
    public int findMin(int[] nums) {

        // Return min element

        // Use binary search to find pivot, return l when nums[l] < nums[r]

        int l = 0;
        int r = nums.length - 1;

        while(l < r) {

            int mid = l + ((r - l) / 2);

            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else if(nums[mid] < nums[r]){ 
                r = mid;
            }

        }

        return nums[l];


    }
}
