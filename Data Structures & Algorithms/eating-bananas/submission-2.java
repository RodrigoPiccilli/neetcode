class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);

        int l = 1;
        int r = piles[piles.length - 1];

        int minRate = Integer.MAX_VALUE;

        while(l <= r) {

            int mid = l + (r-l) / 2;

            int totalHours = findTotalHours(piles, mid);

            if(totalHours > h) {
                l = mid + 1;
            } else {
                minRate = Math.min(mid, minRate);
                r = mid - 1;
            }


        }

        return minRate;
       

    }

    private int findTotalHours(int[] piles, int rate) {

        int totalHours = 0;

        for(int pile : piles) {

            totalHours += (pile / rate);

            if(pile % rate != 0) totalHours++;

        }

        return totalHours;


    }
}
