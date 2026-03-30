class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        Arrays.sort(piles);

        // [1,2,3,4]

        int l = 1;
        int r = piles[piles.length - 1]; // 4

        int minK = piles[piles.length - 1];

        while(l <= r) {

            int rate = l + (r - l) / 2;

            int timeConsumed = findTimeConsumed(piles, rate);

            if(timeConsumed <= h) {
                minK = Math.min(rate, minK);
                r = rate - 1;
            } else {
                l = rate + 1;
            }

        }

        return minK;

    }

    private int findTimeConsumed(int[] piles, int rate) {

        int totalTime = 0;

        for(int pile : piles) {
            totalTime += (pile / rate);
            if(pile % rate != 0) totalTime++;
        }

        return totalTime;

    }
}
