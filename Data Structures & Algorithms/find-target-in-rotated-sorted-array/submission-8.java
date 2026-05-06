class Solution {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while(l < r) {

            int mid = l + (r - l) / 2;

            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else if(nums[mid] < nums[r]) {
                r = mid;
            }

        }

        int result = binarySearch(0, l - 1, target, nums);

        return result != -1 ? result : binarySearch(l, nums.length - 1, target, nums);

    }

    
    
    private int binarySearch(int l, int r, int target, int[] nums) {

        while(l <= r) {

            int mid = l + (r - l) / 2;

            if(nums[mid] < target) {
                l = mid + 1;
            } else if(nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }

        }

        return -1;


    }
}
