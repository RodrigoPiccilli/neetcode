class Solution {
    public int search(int[] nums, int target) {
        
        // Step 1. Find the Pivot
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

        int res = binarySearch(nums, target, 0, l - 1);

        if(res == -1) {
            res = binarySearch(nums, target, l, nums.length - 1);
        }

        return res;

    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        
        while(l <= r) {

            int mid = l + (r - l) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return -1;


    }
}
