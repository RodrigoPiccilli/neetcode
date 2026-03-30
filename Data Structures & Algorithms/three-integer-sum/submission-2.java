class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        /**
        Todo:
        1) Sort Nums Array
        2) Apply 2SUM II rules

        IDEA
        Outer loop normally incrementing
        Inner loop performing 2 SUM II, but skipping current outer loop index?

        How in the world would we check duplicates?!
        
        **/

        List<List<Integer>> solution = new ArrayList();

        int[] sorted = Arrays.copyOf(nums, nums.length);

        Arrays.sort(sorted);

        // [-4, -1, -1, 0, 1, 2]

        for(int i = 0; i < sorted.length - 2; i++) {
            if (i > 0 && sorted[i] == sorted[i - 1]) continue;

            int l = i + 1;
            int r = sorted.length - 1;

            int target = sorted[i] * -1;

            while(l < r) {
                   
                int sum = sorted[l] + sorted[r];

                if(sum < target) {
                    l++;
                } else if(sum > target) {
                    r--;
                } else {
                    solution.add(new ArrayList(Arrays.asList(sorted[i], sorted[l], sorted[r])));
                    while (l < r && sorted[l] == sorted[l + 1]) l++;
                    while (l < r && sorted[r] == sorted[r - 1]) r--;
                    l++;
                    r--;
                }

            }

        }

        return solution;
        
    }
}