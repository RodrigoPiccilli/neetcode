class Solution {
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;

        // [3,4,5,l6,m1,r2]

        while(left <= right) {

            int mid = left + (right - left)/2;

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else if(nums[mid] < nums[right]){
                right = mid;
            } else {
                return nums[mid];
            }

        }

        return nums[left];


    }
}
