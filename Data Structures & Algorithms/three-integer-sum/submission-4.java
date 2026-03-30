class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> solution = new ArrayList();
        
        // Step 1: Sort array so we can iterate without worrying about duplicates.

        int[] sorted =  nums.clone();

        Arrays.sort(sorted); // [-4,-1,-1,0,1,2]

        // Step 2: Have an outer loop going from 0 to length - 3 

        for(int i = 0; i < sorted.length - 2; i++) {

            // Step 3: Skip duplicates if already seen

            if(i > 0 && sorted[i] == sorted[i - 1]) continue;

            // Step 4: Inner loop, which reduces the problem down to Two Sum II

            int l = i + 1;
            int r = sorted.length - 1;

            while(l < r) {

                int target = sorted[i] * -1;

                int sum = sorted[l] + sorted[r];

                if(sum < target) {
                    l++;
                } else if(sum > target) {
                    r--;
                } else {
                    while(l + 1 < sorted.length && sorted[l] == sorted[l + 1]) l++;
                    while(r - 1 >= 0 && sorted[r] == sorted[r - 1]) r--;
                    List<Integer> triplet = Arrays.asList(sorted[i], sorted[l], sorted[r]);
                    solution.add(triplet);
                    l++;
                    r--;
                }

            }

        }

        return solution;


    }
}
