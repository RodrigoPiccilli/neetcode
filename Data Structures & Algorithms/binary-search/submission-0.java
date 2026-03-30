class Solution {
    public int search(int[] nums, int target) {
        
        // Sorted Array
        // Divide Array In Half, Find that Index
        // If nums[index] x == target, return index
        // If nums[index] < target, repeat for left subarray
        // If nums[index] > target, repeat for right subarray

        int head = 0;
        int tail = nums.length - 1;

        while(head <= tail) {

            int i = (head + tail) / 2;

            System.out.println(nums[i]);

            if(nums[i] == target) return i;

            if(head == tail) break;

            if(nums[i] > target) {
                tail = i - 1;
                continue;
            }

            if(nums[i] < target) {
                head = i + 1;
                continue;
            }

        }

        return -1;

    }
}
