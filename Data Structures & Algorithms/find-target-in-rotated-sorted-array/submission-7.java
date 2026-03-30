class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0;

        int r = nums.length - 1;

        while(l < r) { // Trying to find the pivot.

            int mid = l + (r - l) / 2;

            if(nums[mid] == target) return mid;
            if(nums[l] == target) return l;
            if(nums[r] == target) return r;

            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }

        int result = binarySearchHelper(nums, 0, l - 1, target);

        return result == -1 ? binarySearchHelper(nums, l, nums.length - 1, target) : result;
    
    }

    private int binarySearchHelper(int[] nums, int startIndex, int endIndex, int target) {

        int l = startIndex;

        int r = endIndex;

        while(l <= r) {

            int mid = l + (r-l) / 2;

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
