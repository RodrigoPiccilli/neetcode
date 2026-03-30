class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        // [3, 4, 5, 6, 1, 2]

        // Do Binary Search Before the Pivot
        // Do Binary Search After Pivot

        int pivot = 0;

        while(left <= right) {

            int mid = left + (right - left)/2;

            if(nums[mid] == target) return mid;

            if(nums[left] <= nums[right]) {
                pivot = left;
                break;
            } else if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else if(nums[mid] < nums[right]) {
                right = mid - 1;
            }

        }

        int binarySearch1 = binarySearchHelper(nums, 0, pivot - 1, target);

        return binarySearch1 == -1 ?  binarySearchHelper(nums, pivot, nums.length - 1, target) : binarySearch1;
        
    }

    private int binarySearchHelper(int[] nums, int left, int right, int target) {

        // [1, 2, 3, 4, 5]

        while(left <= right) {

            int mid = left + (right - left)/2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            }

        }

        return -1;

    }
}
