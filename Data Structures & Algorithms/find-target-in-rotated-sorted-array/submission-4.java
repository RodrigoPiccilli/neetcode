class Solution {
    public int search(int[] nums, int target) {

        // [3,4,5,6,1,2]

        // Find Pivot

        // Binary Search on Both Sides.
        
        int l = 0;
        int r = nums.length - 1;

        while(l < r) {

            int mid = l + (r - l) / 2;

            // if(nums[mid] == target) return mid;

            if(nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return Math.max(
            binarySearchHelper(nums, 0, l - 1, target), 
            binarySearchHelper(nums, l, nums.length - 1, target));

    }

    private int binarySearchHelper(int[] nums, int startIndex, int endIndex, int target) {

        int l = startIndex;
        int r = endIndex;

        while(l <= r) {

            int mid = l + (r - l) / 2;

            if(nums[mid] == target) return mid;

            if(nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return -1;
        


    }
}
