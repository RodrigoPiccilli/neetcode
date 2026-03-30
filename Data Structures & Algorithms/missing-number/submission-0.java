class Solution {
    public int missingNumber(int[] nums) {

        int totalLength = nums.length;

        int expected = 0;
        int actual = 0;

        while(totalLength >= 0) {
            expected += totalLength;
            totalLength--;
        }

        for(Integer i : nums) {
            actual += i;
        }

        return expected - actual;

        
        
    }
}
