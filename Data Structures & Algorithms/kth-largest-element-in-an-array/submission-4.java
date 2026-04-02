class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int target) {
        
        int pivot = nums[r];
        int trail = l;

        for(int i = l; i <= r; i++) {
            if(nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[trail];
                nums[trail] = temp;
                trail++;

            }
        }

        // Swap Pivot into Right Spot
        int temp = nums[trail];
        nums[trail] = nums[r];
        nums[r] = temp;

        if(trail < target) {
            return quickSelect(nums, trail + 1, r, target);
        } else if(trail > target) {
            return quickSelect(nums, l, trail - 1, target);
        }

        return nums[trail];

    }
}
