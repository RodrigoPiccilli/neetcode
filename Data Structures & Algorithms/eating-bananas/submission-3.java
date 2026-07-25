class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);

        int l = 1;
        int r = piles[piles.length - 1];

        int res = piles[0];

        while (l <= r) {
            // [4 , 10, 23, 25]
            int k = l + (r - l) / 2;

            int total = calculateTotalCount(piles, k);

            if(total > h) {
                l = k + 1;
            } else {
                res = k;
                r = k - 1;
            }
        }

        return res;
    }

    private int calculateTotalCount(int[] piles, int k) {
        
        int total = 0;

        for (int pile : piles) {
            total += Math.ceil((double) pile / k);
        }

        return total;
    }
}
