class Solution {
    public int search(int[] nums, int target) {

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

        int result = binarySearchHelper(nums, 0, l, target);

        return result != -1 ? result : binarySearchHelper(nums, l, nums.length, target);
        
    }

    private int binarySearchHelper(int[] nums, int startIndex, int endIndex, int target) {

        int l = startIndex;
        int r = endIndex - 1;

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
