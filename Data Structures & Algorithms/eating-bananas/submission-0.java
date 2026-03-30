class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    
        // piles[i] = # of bananas in that pile

        // h -> number of hours we have to eat

        // Optimize the eating rate k, find min

        // Perform binary search on k, which can be between 0 <--> max(piles)

        // Store min, keep going down. If hours exceeds the min, we found it.

        Arrays.sort(piles);

        int l = 0;

        int r = piles[piles.length - 1];

        int minRate = Integer.MAX_VALUE;

        while(l <= r) {

            int mid = l + ((r - l) / 2);

            if(mid == 0) break;

            int totalHours = findHours(piles, mid);

            if(totalHours <= h) {
                minRate = Math.min(minRate, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        return minRate;

    }

    private int findHours(int[] piles, int rate) {

        int totalHours = 0;

        for(int pile : piles) {
            totalHours += (pile / rate);
            if(pile % rate != 0) {
                totalHours++;
            }
        }

        return totalHours;

    }


}
